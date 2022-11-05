public class Server3{
    public static void main(String args[]) throws Exception{
        java.net.ServerSocket ss = new java.net.ServerSocket(3333);
        java.net.Socket s = ss.accept();
        java.io.DataInputStream din = new java.io.DataInputStream(s.getInputStream());
        java.io.DataOutputStream dout = new java.io.DataOutputStream(s.getOutputStream());
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        String str = "" , str2 = "";
        while(!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("Client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }

}
