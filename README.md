# DRExercise
How To Run:
  Main Class
 * It takes first argument as feature no and requires extra arguments as per Task to be performed

 * Feature 1: To identify sentence boundary and tokenize the text in the path for the input file ("nlp_data.txt")
    Input: Takes input filename "nlp_data.txt" as second argument
    >java Main 1 nlp_data.txt
 
    Outputs an xml file 
 
 * Feature 2: To add rudimentary recognition of proper nouns  in the input file 
    Input: Takes input path for the file with Named-entities ("NER.txt") as second argument and path for the input filename         ("nlp_data.txt") as third argument
    >java Main 2 NER.txt nlp_data.txt

    Outputs an xml file 
 
 * Feature 3: To parallel process the input files and tokenize 
    Input: Takes input path for the directory extracted from the zip file as second argument and path for the file with             Named-entities ("NER.txt") as third argument
    >java Main 3 nlp_data NER.txt
    >java Main 3 <dir-name> NER.txt

    Outputs an xml file for each input file in the zip file 
    

