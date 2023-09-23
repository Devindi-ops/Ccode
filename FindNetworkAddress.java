import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class NetworkAddressCalculator {
    public static void main(String[] args) {
        try {
            // Specify the IP address, subnet mask, and MAC address
            String ipAddress = "192.168.1.10";
            String subnetMask = "255.255.255.0";
            String macAddress = "00:1A:2B:3C:4D:5E";

            // Parse the IP address and subnet mask
            InetAddress ip = InetAddress.getByName(ipAddress);
            InetAddress subnet = InetAddress.getByName(subnetMask);

            // Calculate the network address
            byte[] ipBytes = ip.getAddress();
            byte[] subnetBytes = subnet.getAddress();
            byte[] networkBytes = new byte[ipBytes.length];

            for (int i = 0; i < ipBytes.length; i++) {
                networkBytes[i] = (byte) (ipBytes[i] & subnetBytes[i]);
            }

            // Create a ByteBuffer for MAC address parsing
            String[] macParts = macAddress.split(":");
            ByteBuffer macBuffer = ByteBuffer.allocate(6);
            for (String part : macParts) {
                macBuffer.put((byte) Integer.parseInt(part, 16));
            }

            // Display the network address
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Subnet Mask: " + subnetMask);
            System.out.println("MAC Address: " + macAddress);
            System.out.print("Network Address: ");
            for (int i = 0; i < networkBytes.length; i++) {
                System.out.print((networkBytes[i] & 0xFF));
                if (i < networkBytes.length - 1) {
                    System.out.print(".");
                }
            }
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
