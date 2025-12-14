public class Main {
    
    static LinkedListBarang list = new LinkedListBarang();
    static QueueBarang queue = new QueueBarang();
    static StackBarang stack = new StackBarang();
    static TreeKategori gudang = new TreeKategori();

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEM LOGISTIK WAREHOUSES SMART");
        System.out.println("==========================================");

        //KATEGORI: ELEKTRONIK
        inputOtomatis("EL01", "Laptop Gaming ROG", "Elektronik", "Andi Saputra", "01-Des", 3.5);
        inputOtomatis("EL02", "Kulkas Side-by-Side", "Elektronik", "Budi Santoso", "01-Des", 85.5);
        inputOtomatis("EL03", "Mesin Cuci Front Load", "Elektronik", "Citra Kirana", "02-Des", 68.2);
        inputOtomatis("EL04", "Smartphone Samsung S24", "Elektronik", "Dewi Lestari", "02-Des", 0.45);
        inputOtomatis("EL05", "AC 1 PK Daikin", "Elektronik", "Eko Patrio", "03-Des", 12.8);

        //KATEGORI: BAYI & BALITA
        inputOtomatis("BY01", "Stroller Bayi Lipat", "Bayi & Balita", "Fanny Fadillah", "04-Des", 7.2);
        inputOtomatis("BY02", "Susu Formula (1 Karton)", "Bayi & Balita", "Gilang Dirga", "04-Des", 4.8);
        inputOtomatis("BY03", "Box Tidur Bayi Kayu", "Bayi & Balita", "Hesti Purwadinata", "05-Des", 18.5);
        inputOtomatis("BY04", "Popok Bayi (5 Ball)", "Bayi & Balita", "Indra Bekti", "05-Des", 6.5);

        //KATEGORI: PAKAIAN
        inputOtomatis("PK01", "Kemeja Batik Premium", "Pakaian", "Joko Anwar", "06-Des", 2.3);
        inputOtomatis("PK02", "Celana Jeans (2 Lusin)", "Pakaian", "Kartika Putri", "06-Des", 14.5);
        inputOtomatis("PK03", "Jaket Parka Winter", "Pakaian", "Luna Maya", "06-Des", 1.2);
        inputOtomatis("PK04", "Sepatu Sneakers (20 Box)", "Pakaian", "Maudy Ayunda", "07-Des", 22.4);

        //KATEGORI: MAKANAN 
        inputOtomatis("MK01", "Beras Premium 50kg", "Makanan", "Nassar Sungkar", "08-Des", 50.2);
        inputOtomatis("MK02", "Minyak Goreng (2 Dus)", "Makanan", "Olla Ramlan", "08-Des", 24.6);
        inputOtomatis("MK03", "Mie Instan (10 Dus)", "Makanan", "Prilly Latuconsina", "09-Des", 4.5);
        inputOtomatis("MK04", "Gula Pasir (1 Sak)", "Makanan", "Qory Sandioriva", "09-Des", 50.1);
        inputOtomatis("MK05", "Frozen Food Nugget", "Makanan", "Raffi Ahmad", "09-Des", 8.75);

        //KATEGORI: ALAT TULIS
        inputOtomatis("AT01", "Kertas A4 (5 Rim)", "Alat Tulis", "Sule Sutisna", "10-Des", 12.5);
        inputOtomatis("AT02", "Tinta Printer Set", "Alat Tulis", "Tukul Arwana", "10-Des", 0.8);
        inputOtomatis("AT03", "Buku Tulis (1 Kardus)", "Alat Tulis", "Uya Kuya", "10-Des", 10.5);

        //KATEGORI: FURNITURE 
        inputOtomatis("FR01", "Sofa Bed Minimalis", "Furniture", "Vicky Prasetyo", "11-Des", 45.5);
        inputOtomatis("FR02", "Meja Makan Jati", "Furniture", "Wendi Cagur", "11-Des", 62.4);
        inputOtomatis("FR03", "Lemari Pakaian 3 Pintu", "Furniture", "Xavier Halim", "12-Des", 78.9);

        //KATEGORI: OTOMOTIF 
        inputOtomatis("OT01", "Ban Mobil R17", "Otomotif", "Yuni Shara", "13-Des", 9.5);
        inputOtomatis("OT02", "Aki Mobil Basah", "Otomotif", "Zaskia Gotik", "13-Des", 14.2);
        inputOtomatis("OT03", "Oli Mesin (1 Drum)", "Otomotif", "Agus Ringgo", "13-Des", 185.5);

        //KATEGORI: KESEHATAN 
        inputOtomatis("KS01", "Kursi Roda Standar", "Kesehatan", "Baim Wong", "14-Des", 16.5);
        inputOtomatis("KS02", "Tabung Oksigen Besar", "Kesehatan", "Cinta Laura", "14-Des", 22.8);
        inputOtomatis("KS03", "Vitamin & Obat (1 Box)", "Kesehatan", "Deddy Mizwar", "14-Des", 1.25);

        //KATEGORI: Z_LAINLAIN
        inputOtomatis("ZZ01", "Barang Antik Guci", "Z_LainLain", "Ernest Prakasa", "15-Des", 8.6);
        inputOtomatis("ZZ02", "Patung Hiasan Tembaga", "Z_LainLain", "Farah Quinn", "15-Des", 25.4);

        list.tampilBarang();

        queue.tampilAntrian();

        stack.tampilStack();

        gudang.lihatIsiGudang();

        ManajemenData admin = new ManajemenData();

        //searching
        admin.cariData(list, "BY03");
    
        admin.cariData(list, "Raffi");

        admin.cariData(list, "Tutu");

        //sorting
        System.out.println("\n--- MENGURUTKAN DATA (SORTING) ---");
        admin.urutkanBeratAscending(list);
    }

    public static void inputOtomatis(String id, String nama, String kat, String pen, String tgl, Double berat) {
        
        list.tambahBarang(id, nama, kat, pen, tgl, berat);
        
        NodeBarang n = new NodeBarang(id, nama, kat, pen, tgl, berat);
        
        queue.enqueue(n);
 
        stack.push(n);
        
        gudang.simpanKeGudang(n);
        
    }
}