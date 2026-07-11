# 📚 Kütüphane Otomasyonu (Library Automation)

Java Swing ile geliştirilmiş, MySQL veritabanı kullanan masaüstü **kütüphane otomasyon** uygulaması. Üniversite bitirme / dönem projesi olarak hazırlanmıştır.

Uygulama; kitap, öğrenci, yazar, yayınevi ve ödünç (emanet) işlemlerini yönetmeyi sağlar. Arayüz **Türkçe**'dir.

---

## ✨ Özellikler

- **Kitap yönetimi** – kitap ekleme, güncelleme, listeleme, tür/tarz (genre), raf adresi ve teslim ayarları
- **Öğrenci yönetimi** – öğrenci kaydı, fakülte ve bölüm bilgileri, öğrenci listesi
- **Yazar & yayınevi yönetimi** – yazar ve yayınevi ekleme/düzenleme
- **Ödünç işlemleri** – kitap emanet verme / iade (book transaction)
- **Yetkilendirme** – Memur (Admin) ve Öğrenci girişleri
- **Raporlama** – JFreeChart ile grafiksel gösterim (pasta grafiği vb.)

---

## 🛠️ Kullanılan Teknolojiler

| Alan | Teknoloji |
|------|-----------|
| Dil | Java (Swing) |
| Derleme | Apache Ant (NetBeans) |
| Veritabanı | MySQL |
| JDBC Sürücü | mysql-connector-java 8.0.23 |
| Grafik | JFreeChart 1.0.19 / JCommon 1.0.23 |

---

## 📁 Proje Yapısı

```
libraryOtomation/
├── src/
│   ├── userInterface/   # Swing arayüz ekranları (.java + .form)
│   ├── Services/        # İş mantığı, DBConnector, metin (Türkçe) sabitleri
│   ├── DAL/             # Veri erişim katmanı / model sınıfları
│   └── Images/          # Arayüz ikon ve görselleri
├── addition/            # Harici .jar bağımlılıkları + SQL yedeği
├── nbproject/           # NetBeans/Ant proje ayarları
├── build.xml            # Ant derleme betiği
└── README.md
```

---

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler
- JDK 8+
- MySQL Server
- (Önerilen) NetBeans IDE

### 1. Veritabanını oluştur
`addition/libraryautomation.sql` dosyasını MySQL'e içe aktarın:

```bash
mysql -u root -p < addition/libraryautomation.sql
```

### 2. Bağlantı ayarını kontrol et
Veritabanı bağlantısı [src/Services/DBConnector.java](src/Services/DBConnector.java) içinde tanımlıdır:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3308/libraryautomation", "root", "");
```

> ⚠️ MySQL'iniz varsayılan portta (3306) çalışıyorsa, port değerini **3306** olarak güncelleyin.
> Şifre ve kullanıcı adını kendi ortamınıza göre düzenleyin.

### 3. Derle ve çalıştır
NetBeans üzerinden projeyi açıp **Run** edebilir veya Ant ile derleyebilirsiniz:

```bash
ant clean jar
java -jar dist/libraryOtomation.jar
```

---

## 👤 Yazar

**fahri** – Üniversite dönem projesi

Depo: <https://github.com/CestnyTR/libraryOtomation>
