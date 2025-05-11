import pandas as pd
def import_export_csv(inp,out):
    df = pd.read_csv(inp)
    print("First row")
    print(df.head())
    df.to_csv(out,index=True)
    print(f"Successfully executed {out}")
inp_csv = "Housing.csv"
out_csv = "output_Housing.csv"
import_export_csv(inp_csv,out_csv)