import csv
import sys
import json

#Json Key names
fieldnames=["name","nametype","recclass","mass","fall","year","id","reclat","reclong"]

def convert(filename):
    csv_filename = filename[0]

    print "Opening CSV file: ",csv_filename 
    f = open(csv_filename, 'r')
    csv_reader = csv.DictReader(f,fieldnames)
    json_filename = csv_filename.split(".")[0]+".json"

    print "Processing JSON : ",json_filename
    jsonf = open(json_filename,'w') 
    data = json.dumps([r for r in csv_reader])
    jsonf.write(data) 
    f.close()
    jsonf.close()

    print "Formating JSON : dbMeteorites.json"
    with open("dbMeteorites.json", "wt") as fout:
       with open(json_filename, "rt") as fin:
           for line in fin:
               fout.write(line.replace(", {", "\n{"))
    fin.close()
    fout.close()

    print "End processing."
 
if __name__=="__main__":
 convert(sys.argv[1:])
