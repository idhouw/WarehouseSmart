public class Main {
    
    // Objek Global
    static LinkedListBarang list = new LinkedListBarang();
    static QueueBarang queue = new QueueBarang();
    static StackBarang stack = new StackBarang();
    static TreeKategori gudang = new TreeKategori();

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEM LOGISTIK GUDANG SKALA BESAR");
        System.out.println("==========================================");
        System.out.println("Memulai proses loading data massal...\n");

        // --- DATA INPUT MASSAL (30+ DATA) ---
        
        // 1. KATEGORI: ELEKTRONIK (Huruf E - Kemungkinan Root)
        inputOtomatis("EL01", "Laptop Gaming ROG", "Elektronik", "Toko Komputer", "01-Des", 4);
        inputOtomatis("EL02", "Kulkas Side-by-Side", "Elektronik", "Hartono", "01-Des", 80);
        inputOtomatis("EL03", "Mesin Cuci Front Loading", "Elektronik", "Ibu Sari", "02-Des", 65);
        inputOtomatis("EL04", "Smartphone Samsung S24", "Elektronik", "Counter HP", "02-Des", 1);
        inputOtomatis("EL05", "AC 1 PK Daikin", "Elektronik", "Kantor A", "03-Des", 12);

        // 2. KATEGORI: BAHAN BANGUNAN (Huruf B - Masuk Kiri E)
        inputOtomatis("BG01", "Semen Tiga Roda (10 Sak)", "Bahan Bangunan", "Proyek X", "04-Des", 500);
        inputOtomatis("BG02", "Cat Tembok 25kg", "Bahan Bangunan", "Pak Tukang", "04-Des", 25);
        inputOtomatis("BG03", "Keramik Lantai 60x60", "Bahan Bangunan", "Proyek X", "05-Des", 200);
        inputOtomatis("BG04", "Pipa PVC 4 Inch", "Bahan Bangunan", "Depo Bangunan", "05-Des", 10);

        // 3. KATEGORI: PAKAIAN (Huruf P - Masuk Kanan E)
        inputOtomatis("PK01", "Kemeja Batik Lusinan", "Pakaian", "Butik Batik", "06-Des", 5);
        inputOtomatis("PK02", "Celana Jeans Gudang", "Pakaian", "Distro Jaya", "06-Des", 15);
        inputOtomatis("PK03", "Jaket Winter Tebal", "Pakaian", "Travel Gear", "06-Des", 3);
        inputOtomatis("PK04", "Sepatu Sneakers (20 Box)", "Pakaian", "Sneaker Head", "07-Des", 20);

        // 4. KATEGORI: MAKANAN (Huruf M - Masuk Kanan B, Kiri P)
        inputOtomatis("MK01", "Beras Premium 50kg", "Makanan", "Agen Sembako", "08-Des", 50);
        inputOtomatis("MK02", "Minyak Goreng Karton", "Makanan", "Warung Madura", "08-Des", 12);
        inputOtomatis("MK03", "Mie Instan (10 Dus)", "Makanan", "Minimarket", "09-Des", 5);
        inputOtomatis("MK04", "Gula Pasir Karung", "Makanan", "Pabrik Gula", "09-Des", 50);
        inputOtomatis("MK05", "Frozen Food Nugget", "Makanan", "Frozen Store", "09-Des", 8);

        // 5. KATEGORI: ALAT TULIS (Huruf A - Masuk Kiri B)
        inputOtomatis("AT01", "Kertas A4 (1 Rim)", "Alat Tulis", "Percetakan", "10-Des", 3);
        inputOtomatis("AT02", "Tinta Printer Epson", "Alat Tulis", "Percetakan", "10-Des", 1);
        inputOtomatis("AT03", "Buku Tulis (1 Kardus)", "Alat Tulis", "Sekolah SD", "10-Des", 10);

        // 6. KATEGORI: FURNITURE (Huruf F - Masuk Kanan E, Kiri P)
        inputOtomatis("FR01", "Sofa Bed Minimalis", "Furniture", "Showroom", "11-Des", 45);
        inputOtomatis("FR02", "Meja Makan Jati", "Furniture", "Pak Ahmad", "11-Des", 60);
        inputOtomatis("FR03", "Lemari Pakaian 3 Pintu", "Furniture", "Ibu Ani", "12-Des", 75);

        // 7. KATEGORI: OTOMOTIF (Huruf O - Masuk Kiri P, Kanan M)
        inputOtomatis("OT01", "Ban Mobil R17", "Otomotif", "Bengkel Ban", "13-Des", 10);
        inputOtomatis("OT02", "Aki Mobil Basah", "Otomotif", "Bengkel Ban", "13-Des", 15);
        inputOtomatis("OT03", "Oli Mesin Drum", "Otomotif", "Bengkel Resmi", "13-Des", 100);

        // 8. KATEGORI: KESEHATAN (Huruf K - Masuk Kiri M)
        inputOtomatis("KS01", "Kursi Roda Standar", "Kesehatan", "RS Umum", "14-Des", 15);
        inputOtomatis("KS02", "Tabung Oksigen Besar", "Kesehatan", "Klinik 24H", "14-Des", 20);
        inputOtomatis("KS03", "Masker Medis (5 Dus)", "Kesehatan", "Apotek", "14-Des", 2);

        // 9. KATEGORI: Z_LAINLAIN (Huruf Z - Paling Kanan)
        inputOtomatis("ZZ01", "Barang Antik Guci", "Z_LainLain", "Kolektor", "15-Des", 10);
        inputOtomatis("ZZ02", "Patung Hiasan", "Z_LainLain", "Gallery", "15-Des", 25);


        System.out.println("\n✔ SELESAI! Total 30+ Barang telah diproses.");

        // --- MENAMPILKAN OUTPUT ---

        // 1. LIST SEMUA BARANG
        list.tampilBarang();

        // 2. QUEUE (Urutan masuk = Urutan Data di atas)
        queue.tampilAntrian();

        // 3. STACK (Data terakhir "Patung Hiasan" akan ada di paling atas)
        stack.tampilStack();

        // 4. TREE GUDANG (Akan mengelompokkan barang berdasarkan Kategori & Total Berat)
        gudang.lihatIsiGudang();
    }

    // Method bantuan untuk input massal
    public static void inputOtomatis(String id, String nama, String kat, String pen, String tgl, int berat) {
        // 1. Masuk List Utama
        list.tambahBarang(id, nama, kat, pen, tgl, berat);
        
        // Buat objek node baru (PENTING: Selalu new NodeBarang agar pointer bersih)
        NodeBarang n = new NodeBarang(id, nama, kat, pen, tgl, berat);
        
        // 2. Masuk Queue (Antrian)
        queue.enqueue(n);
        
        // 3. Masuk Stack (Tumpukan)
        stack.push(n);
        
        // 4. Masuk Gudang (Tree)
        gudang.simpanKeGudang(n);
        
        // Feedback kecil agar layar tidak sepi saat loading
        // System.out.print("."); 
    }
}