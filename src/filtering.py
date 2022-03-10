import pandas as pd
import csv

def createCSV(filepath, list):  # creates CSVs from list
    with open(filepath, 'w', newline='\n', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerows(list)

if __name__ == "__main__":
    lst = []
    
    df = pd.read_csv("Desktop//countries_data.csv")
    lst = [df.loc[i] for i in range(len(df)) if (df.loc[i, "Indicator Code"][:2] in ("NY", "SE", "SD"))]
    createCSV("Desktop//test.csv", lst)
