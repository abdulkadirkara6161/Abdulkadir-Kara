import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
public class StudentSystem {
    boolean exit;
	public static void main(String[] args) {
		
		StudentSystem menu = new StudentSystem();
		menu.runmenu();
		
	
		 try { 
		      File kayýt = new File("C:\\Users\\ABDULKADÝR\\öðrenci.txt"); 
		      if (kayýt.createNewFile()) { 
		        System.out.println("File created: " + kayýt.getName()); 
		      } else { 
		        System.out.println("File already exists."); 
		      } 
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace(); 
		    } 
		
	}
	
	public void runmenu() {
		
		
		while(!exit) {
			int secim = getInput();
			
			if(secim==7) {
				printmenu();
			}
			
			
			action(secim);
		
		}
		
		
	
		
	}
	
	public void delete() {
		
		 try
		    {
		        File silinecekDosya = new File("C:\\Users\\ABDULKADÝR\\öðrenci.txt");
		  
		       
		        if (!silinecekDosya.exists())
		        throw new IllegalArgumentException("Ýlgili Dosya Bulunamadý! : "
		        + silinecekDosya.getAbsolutePath());
		 
		        if (silinecekDosya.delete()) {
		        System.out.println("Dosya Baþarý Ýle Silindi.");
		        }
		 
		        else {
		        System.out.println("Silme Ýþlemi Baþarýsýz!");
		        }
		 
		   }   catch (Exception e) {
		       e.printStackTrace();
		       }
		 }
		
	
	
	
	
	
	
	
		 private int getInput() {
			 Scanner kb = new Scanner(System.in);
		int secim=-1;
		while(secim < 1 || secim >7 ) {
			try {
				System.out.println("choose :");
				secim = Integer.parseInt(kb.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("error , Please choose again");
				
			}
		}
		
		
		
		
		return secim;
	}
		 
		 private void action(int secim) {
			 switch(secim) {
			 
			 case 1:
				 ShowStudent();
				 break;
			 case 2:
				 StudentInfo();
				 break;
			 
			 case 3:
				 update();
				 break;
				 
			 case 4:
				 delete();
				 break;
				 
		      
			   
			 }
			 
			 
		 }
		 public void ShowStudent() {
			 String[] array = null;
			 Scanner enter = new Scanner(System.in);
			 System.out.println("Enter student id");
			 String id=enter.nextLine();
			 
			 try(Scanner input = new Scanner((Readable) new BufferedReader(new FileReader("C:\\Users\\ABDULKADÝR\\öðrenci.txt")))){
					
					while(input.hasNextLine()) {
						
						String reading = input.nextLine();
						array = reading.split(":");
						
						if(array[0].equals(id)) {
							System.out.println(array[1]+" "+array[2]);
						}
					}
					
					
					
					
			 } catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		 }
		 
		 public void StudentInfo() {
			 
			 String[] array = null;
			 try(Scanner input = new Scanner((Readable) new BufferedReader(new FileReader("C:\\Users\\ABDULKADÝR\\öðrenci.txt")))){
					
					while(input.hasNextLine()) {
						
						String reading = input.nextLine();
						array = reading.split(":");
						System.out.println(array[0]+" "+ array[1]+" "+array[2] );
					}
					
					
					
					
			 } catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			 
		 }
		 
		 public void update() {
			 try { 
				 String name ;
				 int id;
				 String surname; 
				 
				 
				 Scanner input = new Scanner(System.in);
			      FileWriter myWriter = new FileWriter("C:\\Users\\ABDULKADÝR\\öðrenci.txt",true);
			      
			      System.out.println("enter the id ");			      
			       id=input.nextInt();
			       input.nextLine();
			       
			       System.out.println("enter the name ");
			       name = input.nextLine();
			       
			       System.out.println("enter the surname ");
			       surname=input.nextLine();
			       
			    
			       
			       
			       
			       
			       
			       
			       
			       
			      
			    		  
			      myWriter.write(id + ":" + name + ":" + surname+"  \n");
			      
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    } 
			 
		 }

		private void printmenu() {
			 
		 System.out.println("1)-SHOW STUDENT INFORMATÝON");
		 System.out.println("2)-SHOW ALL STUDENT ÝNFORMATÝON");
		 System.out.println("3)-UPDATE STUDENT INFORMATÝON");
		 System.out.println("4-)DELETE STUDENT INFORMATÝON");
		 System.out.println("5-)SHOW GPA");
		 System.out.println("6-)SHOW THE AVERAGE GPA");
		 System.out.println("7-)EXÝT MENÜ");
		 
		 
		 
		 

	}

}
