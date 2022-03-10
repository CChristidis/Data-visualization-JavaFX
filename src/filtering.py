import pandas as pd
import csv
import numpy

global in_path = ''         # fill
global out_path = ''        # fill

def filter_csv(infile_path: str, outfile_path: str):
    df = pd.read_csv(infile_path) 
    cols = df.columns
    lst = [df.loc[i] for i in range(len(df)) if (df.loc[i, "Indicator Code"][:2] in ("NY", "SE", "SD"))]
    arr = numpy.asarray(lst)
    df = pd.DataFrame(arr)
    df.columns = cols
    df.to_csv(outfile_path)  
   

if __name__ == "__main__":
    filter_csv(in_path, out_path)
