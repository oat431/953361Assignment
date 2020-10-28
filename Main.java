import java.util.*;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Pattern: -x <unique number> -t <type of protocol> -s <host name> -p <Port number>");
        System.out.print("enter your command: ");
        String Input = in.nextLine();
        String[] List = Input.split(" ");
        List<String> Data = Arrays.asList(List);

        try {
            if (!Data.get(0).equals("-x")) {
                System.out.println("Command not found");
            } else if (!Data.get(2).equals("-t")) {
                System.out.println("Command not found");
            } else if (!Data.get(4).equals("-s")) {
                System.out.println("Command not found");
            } else if (!Data.get(6).equals("-p")) {
                System.out.println("Command not found");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter the command by pattern above");
        }

        String Protocol = Data.get(3).toUpperCase();

        if (Protocol.equals("TCP")) {
            new TCPClient(Integer.parseInt(Data.get(1)), Data.get(5), Integer.parseInt(Data.get(7)),"TCP");

        } else if (Protocol.equals("UDP")) {
            new UDPClient(Integer.parseInt(Data.get(1)), Data.get(5), Integer.parseInt(Data.get(7)),"UDP");

        } else {
            System.out.println("Please enter the command by pattern above");
        }

    }

}