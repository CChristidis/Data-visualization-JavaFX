import pandas as pd
import numpy

in_file = ''                    # countries_data.csv
out_file = ''                   # year_value.csv


def get_rows_of_wanted_indicators(df, ind_tuple):
    filtered_list = [df.loc[i] for i in range(len(df)) if (df.loc[i, "Indicator Code"][:2] in ind_tuple)]
    return filtered_list


def filter_indicators(in_file: str):
    df = pd.read_csv(in_file)
    cols = df.columns

    """ Filter all unwanted rows."""
    filtered_list = get_rows_of_wanted_indicators(df, ("NY", "SE", "SD"))

    arr = numpy.asarray(filtered_list)
    df = pd.DataFrame(arr)
    df.columns = cols

    return df


def add_countryid_indicatorid(df):
    countriesdf = df.filter(['Country Name', 'Country Code'])
    countriesdf = countriesdf.drop_duplicates(subset=None, keep='first', inplace=False)
    countriesdf['index_country'] = range(1, len(countriesdf) + 1)

    indicatorsdf = df.filter(['Indicator Name', 'Indicator Code'])
    indicatorsdf = indicatorsdf.drop_duplicates(subset=None, keep='first', inplace=False)
    indicatorsdf['index_indicat'] = range(1, len(indicatorsdf) + 1)

    dfnew = pd.merge(countriesdf, df, how='inner', on='Country Name')
    dfnew = dfnew.drop('Country Code_y', 1)
    dfnew = dfnew.drop('Country Code_x', 1)
    dfnew = pd.merge(indicatorsdf, dfnew, how='inner', on='Indicator Name')
    dfnew = dfnew.drop('Indicator Code_y', 1)
    dfnew = dfnew.rename(columns={'Indicator Code_x': 'Indicator Code', 'Country Code_x': 'Country Code'})

    df_ind_years = dfnew.drop(columns=['Indicator Name', 'Indicator Code', 'Country Name'])

    return df_ind_years


def unpivot_df(df):
    df_unpivoted = df.melt(id_vars=['index_country', 'index_indicat'], var_name='Years', value_name='Values')
    df_unpivoted.reset_index()

    df = pd.melt(df, id_vars=["index_country", "index_indicat"])
    df.dropna(subset=['value'])

    df = df.rename(columns={'index_country': 'id_country', 'index_indicat': 'id_ind', 'variable': 'year'})

    return df

def main():
    df = filter_indicators(in_file)
    df = add_countryid_indicatorid(df)
    df = unpivot_df(df)

    df.to_csv(out_file, index=False)  # index=False removes index column.
    

if __name__ == "__main__":
    main()
    

