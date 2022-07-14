Problem Statement : 
>>>> Inputs : Admin i/o , 
2 types of csv txt files : 
1)Roll Lists of sections appearing for exam. 
(User I/P ki kitne sections h >> while/for loop >> data read for each file )
2)Classes available(Total classes ) plus class occupancy.<class no,no of seats>

>>>> Outputs : In csv file that can be openend in excel.
1. Make a file (write/append mode).
2. Write csv data in file for classes in foll way : 

Room No: 108
Seat No.,Roll No. of Student 1 from sec A,Roll No. of Student from sec B
001,5A1,4A1
.
 .
 .
 .
 025,5A25,4A25
 .
 Class No. : 02
 001,5A26,4A26

 015,5A40,4A40
 016,5B01,4A41
 .
 .
 .
 .
 --------------------

 BufferFileInput = .....(new (".txt"))
 