public class Client3 {
    public static void main(String args[]) throws Exception{
        java.net.Socket s = new java.net.Socket("localhost",3333);
        java.io.DataInputStream din = new java.io.DataInputStream(s.getInputStream());
        java.io.DataOutputStream dout = new java.io.DataOutputStream(s.getOutputStream());
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        String str = "" , str2 = "";
        while(!str.equals("stop")) {
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str2 = din.readUTF();
            System.out.println("Server says : "+str2);
        }
        dout.close();
        s.close();
    }
}
