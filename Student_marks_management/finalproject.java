


import java.util.Arrays;
import java.util.Scanner;

public class finalproject {
	static String[] s_idarray=new String[100]; //student ID array
	static String[] s_namearray=new String[100]; //student NAME array
	static int[] s_marks1array=new int[100];   //Programming Fundamental Marks array
	static int[] s_orderedmarks1array=new int[100];  //Sorted programming fundamental Marks array
	static int[] s_marks2array=new int[100];  //Database Management Marks array
	static int[] s_orderedmarks2array=new int[100];  //Sorted Database Management Marks array
	static float[] s_average=new float[100]; //Average marks array
	static float[] s_Ranks=new float[100];  //Sorted average marks array
	static int stu_count=0; 
	static int rank;
	public static void setintvalue() {   //set default value of marks arrays as -1
		for (int i=0;i<s_marks1array.length;i++) {
			s_marks1array[i]=-1;
			s_marks2array[i]=-2;
			}
	}
	public static void setstringvalue() {  //set default value of id and name array as 0
		for (int i=0;i<s_idarray.length;i++) {
			s_idarray[i]="0";
			s_namearray[i]="0";
			}
	}
	private static void HomePage() {  //print the home page including options
    	System.out.println("\n=====================WELCOME TO GDSE MARKS MANAGEMENT SYSTEM========================");
		String[] array= {"[1] Add New Student","[2] Add New Student With Marks ","[3] Add Marks","[4] Update Student Details","[5] Update Marks",
				            "[6] Delete Student","[7] Print Student Details","[8] Print Student Ranks","[9] Best in Programming Fundamentals",
				            "[10] Best in Database Management System"};
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
    	 }
	private static void AddNewStudent() {  //add new student with ID and Name
	    System.out.println("\n=====================Add New Student========================");
	    while (true) {
	        boolean new1 = false;
	        Scanner sc1 = new Scanner(System.in);
	        System.out.println("Enter Student ID   :");
	        String s_id = sc1.nextLine();
            for (int j = 0; j < stu_count; j++) {  //check whether entered ID is already in the ID array
	            if (s_idarray[j].equals(s_id)) {
	                new1 = true;
	                break;
	            }
	        }
            if (new1==true) { //when student ID already exist in the system
	        	System.out.println("The Student Id already exists ");
	            continue;
	        } if (!new1) {   //add new student to the ID array and Name array
	            s_idarray[stu_count] = s_id;
                Scanner sc2 = new Scanner(System.in);
	            System.out.println("Enter Student Name :");
	            String s_name = sc2.nextLine();
	            s_namearray[stu_count] = s_name;
	            System.out.println("Student has been added successfully");
                Scanner sc3 = new Scanner(System.in);
	            System.out.println("Do you want to add a new student (Y/n) :");
	            String y_or_no = sc3.nextLine();
	            if (y_or_no.equalsIgnoreCase("n")) { //when want to stop add student to the system next going to the main menu
	            	runner();
	                break;
	            }
	            stu_count++;
	        }
	    }
	    stu_count++;
	}
    private static void AddNewStudentWithMarks() {
    	System.out.println("\n=====================Add New Student With Marks========================");
    	while(true) {
    		  boolean new1 = false;
    	      Scanner sc4=new Scanner (System.in);
	          System.out.println("Enter Student ID   :");
	          String s_id1=sc4.nextLine();
	          for (int j = 0; j < stu_count; j++) {
		            if (s_idarray[j].equals(s_id1)) { //check whether student has already registered to the system
                        new1 = true;
		                break;
		            }
		        }
	          if (new1==true) {
		        	System.out.println("The Student Id already exists ");
		            continue;
		        } if (!new1) {
		        	 Scanner sc5=new Scanner (System.in);
			          System.out.println("Enter Student Name :");
			          String s_name1=sc5.nextLine();
			          s_idarray[stu_count] = s_id1;
			          s_namearray[stu_count]=s_name1;
			          while(true) {
			        	    Scanner sc6=new Scanner (System.in);
			                System.out.println("Programming Fundamentals Marks     :");
			                int s_marks1=sc6.nextInt();  //add PFM in to the array
			                s_marks1array[stu_count]=s_marks1;
			                if(0>s_marks1 || s_marks1>100) { // check whether the marks are in correct range
			        	         System.out.println("Invalid marks, please enter correct marks");
			        	         continue;
			                }
			                break;
			          }
			          while(true) {
			                Scanner sc7=new Scanner (System.in);
			                System.out.println("Database Management System Marks   :");
			                int s_marks2=sc7.nextInt(); //add DBM marks to the array
			                s_marks2array[stu_count]=s_marks2;
			                if(0>s_marks2 || s_marks2>100) {
			        	         System.out.println("Invalid marks, please enter correct marks");
			        	         continue;
			                }
			                break;
			                }
			          Scanner sc8=new Scanner (System.in);
			          System.out.println("Do you want to add a new student (Y/n) :");
		    	      String y_or_no=sc8.nextLine();
		    	      if(y_or_no.equals("n")) {  //when want to stop add student to the system next going to the main menu
		    	    	  runner();
		    	    	  break;
		    	    	  }
		    	      stu_count++;
		        }
	         }
    	stu_count++;
    }
    public static void AddMarks() {
    	System.out.println("\n=====================Add Marks========================");
    	outerLoop1:
    	while(true) {
    		boolean check = true;
    	     Scanner sc9=new Scanner (System.in);
             System.out.println("Enter Student ID :");
	         String s_id2=sc9.nextLine();
	         outerLoop:
	         for(int j=0;j<stu_count;j++){
	        	 if(s_idarray[j].equals(s_id2)) { //check whether student has registered to the system
	        		 int index=j;
	        		 check =false;
		    	     System.out.println("Student Name   :"+s_namearray[index]);
		    	     while(true) {
	        	         if(s_marks1array[index]==-1) { // check whether the mark has already add to the array
	                    	 Scanner sc10=new Scanner (System.in);
		                     System.out.println("Programming Fundamentals Marks     :");
		                     int s_marks1=sc10.nextInt();
	                    	 if(0>s_marks1 || s_marks1>100) {  //check marks are in correct range
		        	             System.out.println("Invalid marks, please enter correct marks");
		        	             continue;
		                     }
	                    	 s_marks1array[index]=s_marks1;
	                    	 break;
	                     }
	                     else { //when marks of the student has already added
	                    	 System.out.println("This student's marks have been already aded.");
	                    	 System.out.println("If you want to update the marks, please use [4] Update marks option");
	                    	 Scanner sc11=new Scanner (System.in);
			                 System.out.println("Do you want to add marks for another student? (Y/n)  :");
			                 String y_or_no=sc11.nextLine();
				    	      if(y_or_no.equals("n")) {
				    	    	  runner();
				    	    	  break outerLoop1;
				    	    	  }
				    	      else {
				    	    	  continue outerLoop1;
				    	      }
	                     }
	                     }
		    	     while(true) {     //to the DBM marks
		                 if(s_marks2array[index]==-2) {
		                	 Scanner sc12=new Scanner (System.in);
			                 System.out.println("Database Management System Marks   :");
			                 int s_marks2=sc12.nextInt();
			                 if(0>s_marks2 || s_marks2>100) {
		        	             System.out.println("Invalid marks, please enter correct marks");
		        	             continue;
		                     }
	                    	 s_marks2array[index]=s_marks2;
	                    	 Scanner sc14=new Scanner (System.in);
	          	             System.out.println("Marks have been added. Do you want to add marks for another student? (Y/n)  :");
	          	             String y_or_no=sc14.nextLine();
	          	             if(y_or_no.equals("n")) {
	          	            	runner();
	          	    	        break outerLoop1; 
	          	    	        }
		                     break;
	                     }
	                     else {
	                    	 System.out.println("This student's marks have been already aded.");
	                    	 System.out.println("If you want to update the marks, please use [4] Update marks option");
	                    	 Scanner sc13=new Scanner (System.in);
			                 System.out.println("Do you want to add marks for another student? (Y/n)  :");
			                 String y_or_no=sc13.nextLine();
				    	      if(y_or_no.equals("n")) {
				    	    	  runner();
				    	    	  break outerLoop1;
				    	    	}
				    	      else {
				    	    	  continue outerLoop1;
				    	      }
	                     }
	                }
	         }
	         }
	        	 if(check) {
	        	   System.out.println("Invalid Student ID. Do you want to search it again?");
	       	       continue;
	           }
	           }
    	}
    	public static void UpdateStudentDetails() {
    		System.out.println("\n=====================UPDATE STUDENT DETAILS========================");
    		outerloop:
        	while(true) {
        		 boolean check2 = true;
        	     Scanner sc9=new Scanner (System.in);
                 System.out.println("Enter Student ID :");
    	         String s_id2=sc9.nextLine();
    	        for(int j=0;j<stu_count;j++){
    	        	 if(s_idarray[j].equals(s_id2)) { //check whether student has registered to the system
    	        		 int index=j;
    	        		 check2 =false;
    		    	     System.out.println("Student Name   :"+s_namearray[index]);
    		    	     Scanner sc10=new Scanner (System.in);
    	                 System.out.println("Enter the new student name :");
    	    	         String new_name=sc10.nextLine();
    	    	         s_namearray[index]=new_name; // update the name of the student
    	    	         System.out.println("Student details has been updated successfully");
    	    	         Scanner sc15=new Scanner (System.in);
    	    	         System.out.println("Do you want to update another student details? (Y/n)");
    	    	         String y_or_no=sc15.nextLine();
    	    	         if(y_or_no.equals("n")) {
    	    	        	 runner();
    	 	    	        break outerloop; 
    	 	    	        }
    	    	         }
    	         }
    	         if(check2) {
  	        	   System.out.println("Invalid Student ID. Do you want to search it again?");
  	       	       continue;
  	           }
        	}
    		    	     }
    	public static void UpdateMarks() {
            System.out.println("\n=====================UPDATE MARKS========================");
    		outerloop:
        	while(true) {
        		 boolean check2 = true;
        	     Scanner sc9=new Scanner (System.in);
                 System.out.println("Enter Student ID :");
    	         String s_id2=sc9.nextLine();
    	         for(int j=0;j<stu_count;j++){
    	        	 if(s_idarray[j].equals(s_id2)) {  //check whether student has registered to the system
    	        		 int index=j;
    	        		 check2 =false;
    		    	     System.out.println("Student Name   :"+s_namearray[index]);
    	        		 if(s_marks1array[index]!=-1) { // check whether the student marks has already added to the system
    	        			 System.out.println("Programming Fundamentals Marks  :" +s_marks1array[index]);
        		    	     System.out.println("Database Managment System Marks :" +s_marks2array[index]);
        		    	     Scanner sc10=new Scanner (System.in);
        	                 System.out.println("Enter the new Programming Fundamentals Marks   :");
        	    	         int new_marks1=sc10.nextInt(); //add PF marks
        	    	         s_marks1array[index]=new_marks1;
        	    	         Scanner sc11=new Scanner (System.in);
        	                 System.out.println("Enter the new Database Managment System Marks   :");
        	    	         int new_marks2=sc11.nextInt();
        	    	         s_marks2array[index]=new_marks2; //add DBM marks
        	    	         System.out.println("Marks have been updated successfully");
        	    	         Scanner sc15=new Scanner (System.in);
        	    	         System.out.println("Do you want to update marks for another student? (Y/n)");
        	    	         String y_or_no=sc15.nextLine();
        	    	         if(y_or_no.equals("n")) {
        	    	        	 runner();
        	 	    	        break outerloop; 
        	 	    	        }
        	    	          }
    	        		 else {
    	        			 System.out.println("This student's marks yet to be added.");
    	        			 Scanner sc15=new Scanner (System.in);
        	    	         System.out.println("Do you want to update marks for another student? (Y/n)");
        	    	         String y_or_no=sc15.nextLine();
        	    	         if(y_or_no.equals("n")) {
        	    	        	 runner();
        	 	    	        break outerloop; 
        	 	    	        }
    	        		 }
    	        		  }
    	         }
    	         if(check2) { //when the student ID is not in the ID array
  	        	   System.out.println("Invalid Student ID. Do you want to search it again?");
  	       	       continue;
  	           }
        	}
    		}
    	public static void DeleteStudent() {
            System.out.println("\n=====================DELETE STUDENT========================");
    		outerloop:
        	while(true) {
        		 boolean check2 = true;
        	     Scanner sc9=new Scanner (System.in);
                 System.out.println("Enter Student ID :");
    	         String s_id2=sc9.nextLine();
    	        for(int j=0;j<stu_count;j++){  //check whether student has registered to the system
    	        	 if(s_idarray[j].equals(s_id2)) {
    	        		 int index=j;
    	        		 check2 =false;
    	    	         System.out.println("Student has been deleted successfully.");
    	    	         s_idarray[index]="0";  //delete the ID of student from the system
    	    	         s_marks1array[index]=-1; //delete the marks of PF of student from the system
    	    	         s_marks2array[index]=-2; //delete the marks of DBM of student from the system
    	    	         s_namearray[index]="0"; //delete the name of student from the system
    	    	         Scanner sc15=new Scanner (System.in);
    	    	         System.out.println("Do you want to delete another student? (Y/n)");
    	    	         String y_or_no=sc15.nextLine();
    	    	         if(y_or_no.equals("n")) {
    	    	        	runner();  //go to the main menu
    	 	    	        break outerloop; 
    	 	    	        }
    	    	         }
    	         }
    	         if(check2) {
  	        	   System.out.println("Invalid Student ID. Do you want to search it again?");
  	       	       continue;
  	           }
        	}
    	}
    	public static void average() { //calculate the average
    		for(int i=0;i<stu_count;i++) {
    			if(s_marks1array[i]>0 || s_marks2array[i]>0) {
    				s_average[i] = (float)(s_marks1array[i]+s_marks2array[i])/2;
    		}
    		}
    	}
    	public static void Student_rank() { //sort average marks in descending order
    		for (int i = 0 ; i < s_average.length; i++) {
    			s_Ranks[i] = s_average[i];
    		}
            float max=0;
    		for(int i=0;i<s_average.length;i++) {
    			for(int j=i+1;j<s_average.length;j++) {
    				if(s_Ranks[i]<s_Ranks[j]) {
    					max=s_Ranks[i];
    					s_Ranks[i]=s_Ranks[j];
    					s_Ranks[j]=max;
    				}
    			}
    		    }
    		}
    	public static void PrintStudentDetails() {
    		
            System.out.println("\n=====================PRINT STUDENT DETAILS========================");
    		outerloop:
        	while(true) {
        		 int index2 = 0;
        		 boolean check2 = true;
        	     Scanner sc9=new Scanner (System.in);
                 System.out.println("Enter Student ID :");
    	         String s_id2=sc9.nextLine();
    	         for(int j=0;j<stu_count;j++){
    	        	 if(s_idarray[j].equals(s_id2)) { //check whether student has registered to the system
    	        		 int index=j;
    	        		 check2 =false;
    	        		 System.out.println("Student Name   :"+s_namearray[index]); 
    		    	     if(s_marks1array[index]!=-1) {  //if marks has been added printing them
    		    	    	 System.out.println("Programming Fundamentals Marks   :"+s_marks1array[index]);
    		    	    	 System.out.println("Database Management System Marks :"+s_marks2array[index]);
    		    	         System.out.println("Total Marks                      :"+(s_marks1array[index]+s_marks2array[index]));
    	    	             System.out.println("Avg. Marks                       :"+s_average[index]);
    	    	             rank=0;
    	    	             for(int k=0;k<s_average.length;k++){
    	    		        	 if(s_Ranks[k]==s_average[index]) {
    	    		        		 index2+=k;
    	    		        		 rank=index2+1;
    	    		        		 break;
    	    		        	 }
    	    		        	}
    	    	             System.out.println("Rank                             :"+rank);
    	    	             Scanner sc15=new Scanner (System.in);
        	    	         System.out.println("Do you want to seach another student details? (Y/n)");
        	    	         String y_or_no=sc15.nextLine();
        	    	         if(y_or_no.equals("n")) {
        	    	        	 runner();
        	 	    	        break outerloop; 
        	 	    	        }
    	        	 }
    		    	     else { //when marks of the student has not been added
    		    	    	 System.out.println("This student's marks yet to be added.");
    	        			 Scanner sc15=new Scanner (System.in);
        	    	         System.out.println("Do you want to seach another student details? (Y/n)");
        	    	         String y_or_no=sc15.nextLine();
        	    	         if(y_or_no.equals("n")) {
        	    	        	 runner();
        	 	    	        break outerloop; 
        	 	    	        }
    		    	     }
    	         }
    	         }
    	         if(check2) {
  	        	   System.out.println("Invalid Student ID. Do you want to search it again?");
  	       	       continue;
  	           }
        	}
    		}
    	public static void PrintStudentRanks() {
    		System.out.println("\n=====================PRINT STUDENT RANKS========================");
    		System.out.println("Rank    "+"ID    "+"Total Marks    " +"Avg.Marks");
    		for(int i=0;i<s_average.length;i++) {
    			int index2=0;
    			if(s_average[i]>0) { 
    				rank=0;
   	                for(int k=0;k<s_average.length;k++){
   		        	 if(s_Ranks[k]==s_average[i]) {
   		        		 index2+=k;
   		        		 rank=index2+1;  //get the rank of i th student
   		        		}
   		        	}
   	                System.out.println(rank+"       " +s_idarray[i]+"      "+ (s_marks1array[i]+s_marks2array[i])+"          "+s_average[i] );
   	                } // print details of i th student
    		}
    		runner();
    	}
    	public static void Best_in_Programming_Fundamentals() {
    		System.out.println("\n=====================BEST IN PROGRAMMING FUNDAMENTALS ========================");
    		int index3=0;
    		int index_of_student=0;
    		for (int i = 0 ; i < s_marks1array.length; i++) {
    			s_orderedmarks1array[i] = s_marks1array[i];  
    		}
    		int max=0;
    		for(int i=0;i<s_orderedmarks1array.length;i++) {
    			for(int j=i+1;j<s_orderedmarks1array.length;j++) {
    				if(s_orderedmarks1array[i]<s_orderedmarks1array[j]) {
    					max=s_orderedmarks1array[i];
    					s_orderedmarks1array[i]=s_orderedmarks1array[j];
    					s_orderedmarks1array[j]=max;  //creating array including PF marks in descending order
    				}
    			}
    		    }
    		System.out.println("ID    "+"Name    "+"PF Marks    "+"DBMS Marks    ");
    		for(int i=0;i<s_marks1array.length;i++) {
    			for(int j=0;j<s_marks1array.length;j++) {
    				if(s_marks1array[j]>0) {
        				if(s_marks1array[j]==s_orderedmarks1array[index3]) {
        					 index_of_student=j;
        					 index3++;
        					 System.out.println(s_idarray[index_of_student]+"       "+s_namearray[index_of_student]+"      "+s_marks1array[index_of_student]+"        "+s_marks2array[index_of_student]);
        					 break;		
        				}
        			}
    				}
    		}
    		runner();
    	}
    	public static void Best_in_Database_management_system() {
    		System.out.println("\n=====================BEST IN DATABASE MANAGEMENT SYSTEM ========================");
    		int index3=0;
    		int index_of_student=0;
    		for (int i = 0 ; i < s_marks2array.length; i++) {
    			s_orderedmarks2array[i] = s_marks2array[i];
    		}
    		int max=0;
    		for(int i=0;i<s_orderedmarks2array.length;i++) {
    			for(int j=i+1;j<s_orderedmarks2array.length;j++) {
    				if(s_orderedmarks2array[i]<s_orderedmarks2array[j]) {
    					max=s_orderedmarks2array[i];
    					s_orderedmarks2array[i]=s_orderedmarks2array[j];
    					s_orderedmarks2array[j]=max; //creating array including DBM marks in descending order
    				}
    			}
    		    }
    		System.out.println("ID    "+"Name    "+"PF Marks    "+"DBMS Marks    ");
    		for(int i=0;i<s_marks2array.length;i++) {
    			for(int j=0;j<s_marks2array.length;j++) {
    				if(s_marks2array[j]>0) {
        				if(s_marks2array[j]==s_orderedmarks2array[index3]) {
        					 index_of_student=j;
        					 index3++;
        					 System.out.println(s_idarray[index_of_student]+"       "+s_namearray[index_of_student]+"      "+s_marks1array[index_of_student]+"        "+s_marks2array[index_of_student]);
        					 break;		
        				}
        			}
    				}
    		}
    		runner();
    	}
    public static void main(String[] args) {
		HomePage();
		setintvalue();
		setstringvalue();
		runner();
	}
	public static void runner() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice :");
		int option=sc.nextInt();
		switch (option) {
		case 1:
			AddNewStudent();
			break;
		case 2:
			AddNewStudentWithMarks();
			break;
		case 3:
			AddMarks();
			break;
		case 4:
			UpdateStudentDetails();
			break;
		case 5:
			UpdateMarks();
			break;
		case 6:
			DeleteStudent();
			break;
		case 7:
			average();
			Student_rank();
			PrintStudentDetails();
			break;
		case 8:
			average();
			Student_rank();
			PrintStudentRanks();
			break;
		case 9:
			average();
			Student_rank();
			Best_in_Programming_Fundamentals();
			break;
		case 10:
			average();
			Student_rank();
			Best_in_Database_management_system();
			break;
		}
		}
	}