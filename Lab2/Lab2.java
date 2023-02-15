import java.util.*;
public class Lab2 {
  public static void main(String[] args){
    scanner scan = new Scanner(System.in);
    String arr[] = new String[1024];
    int arrLen = 0;
    int loopControl = 0;

    do{
      //printing the menu option
      Sysyem.out.println("Menu OPtions.\n1.enter name.\n2.List alll\n.3.Remove name\n.4Search\n.5Exit")
      int userChoice=Integer.parsInt(scan.nextLine());
      switch(userchoice){
        case1:
            System.out.println("Enter the new name: ");
            String tempName = scan.nextLine();
            boolean addName= false;

            if(arrLen == 0){
              addName = true;
            }else{
              for(int i=0;i<arrLen;i++){
                if(arr[i].equalsIgnoreCase(tempName)){
                    addName = flase;

                }else{
                    addName = true;
                }
              }
            }

            if(addName == true){
              arr[arrLen] = tempName;
              arrLen = arrLen + 1;
              System.out.println("Name Added");

            }else{
                System.out.println("Name existes..");
            }
              break;
        case2:
            for(int i=0;i<arrLen;i++){}
              break;
        case3:
              break;
        case4:
              break;
        default:
              System.out.println("Wrong Choice");
      }
      System.out.println("Press 1 to continue ....!");
      loopControl = Integer.parseInt(scan.nextLine());

    }while(loopControl == 1);

    System.out.println("Program Exits")
  }
}