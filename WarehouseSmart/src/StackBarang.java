public class StackBarang {

    private class ElemenStack {
        NodeBarang data;
        ElemenStack next;

        ElemenStack(NodeBarang data) {
            this.data = data;
            this.next = null;
        }
    }

    private ElemenStack top;

    public void push(NodeBarang barang) {
        ElemenStack baru = new ElemenStack(barang);
        baru.next = top;
        top = baru;
    }

    public void tampilStack() {
        System.out.println("\n=== [3] ISI RAK TRANSIT (STACK - LIFO) ===");
        if (top == null) {
            System.out.println(" [ Rak Kosong ] ");
            return;
        }

        System.out.println("       [ BAGIAN ATAS RAK ]");
        System.out.println("+-------+--------------------------+");
        System.out.println("| ID    | NAMA BARANG              |");
        System.out.println("+-------+--------------------------+");

        ElemenStack temp = top;
        while (temp != null) {
            System.out.printf("| %-5s | %-24s |\n", 
                    temp.data.idBarang, 
                    potongNama(temp.data.namaBarang, 24));
            temp = temp.next;
        }
        System.out.println("+-------+--------------------------+");
        System.out.println("       [ BAGIAN BAWAH RAK ]");
    }

    private String potongNama(String nama, int max) {
        if (nama.length() > max) return nama.substring(0, max - 3) + "...";
        return nama;
    }
}