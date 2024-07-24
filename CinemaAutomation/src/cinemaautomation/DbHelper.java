package cinemaautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbHelper {
    Connection connection = null;
    PreparedStatement preparedstatement = null;
    ResultSet resultSet;
    Statement stmt;

    private String userName = "root";
    private String password = "Esra.123";
    private String url = "jdbc:mysql://localhost:3306/sinemaotomasyonu";

    public DbHelper() {
        try {
            connection = getConnection();
            if(connection != null)  System.out.println("Baglanti basarili!");
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, userName, password);
    }

    public void showErrorMessage(SQLException e) {
        System.out.println("Error: " + e.getMessage());
        System.out.println("Error code : " + e.getErrorCode());
    }
    
    //
    public void insertUser(String isim, String soyisim, String kullanici_adi, String sifre, String cinsiyet) throws SQLException {

        try {
            //Bağlantı burda kuruluyor

            if (userExist(kullanici_adi) == false) {
                String sql = "INSERT INTO kullanicibilgileri (Ad, Soyad, KullaniciAdi, Sifre, Cinsiyet) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, isim);
                preparedStatement.setString(2, soyisim);
                preparedStatement.setString(3, kullanici_adi);
                preparedStatement.setString(4, sifre);
                preparedStatement.setString(5, cinsiyet);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Yeni kullanıcı başarıyla eklendi.");
                } else {
                    System.out.println("Kullanıcı eklenirken bir hata oluştu.");
                }
            } else {
                System.out.println("Kullanıcı mevcut"); //KULLANICI KAYITLI MESAJI
            }

        } catch (SQLException e) {
            showErrorMessage(e);
        } finally {
            if (preparedstatement != null) {
                preparedstatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
    //aynı kullanıcı adına sahip başka biri var mı diye kontrol eden method
    public boolean userExist(String kullanici_adi) {
        String sql = "SELECT COUNT(*) FROM kullanicibilgileri WHERE KullaniciAdi = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kullanici_adi);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println((count > 0) + "user exist");
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    //Bilet bilgilerini veri tabanına ekleme işlemi yapar
    public void insertTicket(String MusteriAdi, String FilmAdi, String Salon, String FilmSaati, int BiletFiyati) throws SQLException{
        String sql = "INSERT INTO biletbilgileri (MusteriAdi, FilmAdi, Salon, FilmSaati, BiletFiyati) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                preparedStatement.setString(1, MusteriAdi);
                preparedStatement.setString(2, FilmAdi);
                preparedStatement.setString(3, Salon);
                preparedStatement.setString(4, FilmSaati);
                preparedStatement.setInt(5, BiletFiyati);
        
                
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Yeni bilet başarıyla eklendi.");
                } else {
                    System.out.println("Bilet eklenirken bir hata oluştu.");
                }
    }
    
    
    public void DeleteTicket(int BiletID) throws SQLException{
        String sql = "DELETE FROM biletbilgileri WHERE BiletID = ?";
                PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
                preparedStatement.setInt(1, BiletID);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Bilet başarıyla silindi.");
                } else {
                    System.out.println("Bilet silinirken bir hata oluştu.");
                }
       
    }
    
    
    
    public void insertFilm(String FilmAdi, String FilmTuru, String VizyonTarihi, int Sure, String Yonetmen) throws SQLException{
        String sql = "INSERT INTO filmbilgileri (FilmAdi, FilmTuru, VizyonTarihi, Sure, Yonetmen) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                preparedStatement.setString(1, FilmAdi);
                preparedStatement.setString(2, FilmTuru);
                preparedStatement.setString(3, VizyonTarihi);
                preparedStatement.setInt(4, Sure);
                preparedStatement.setString(5, Yonetmen);
        
                
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Yeni film başarıyla eklendi.");
                } else {
                    System.out.println("Film eklenirken bir hata oluştu.");
                }
    }
    
    public void DeleteFilm(int FilmID) throws SQLException{
        String sql = "DELETE FROM filmbilgileri WHERE FilmID = ?";
                PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
                preparedStatement.setInt(1, FilmID);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Film başarıyla silindi.");
                } else {
                    System.out.println("Film silinirken bir hata oluştu.");
                }
       
    }
    
    public boolean filmExist(String FilmAdi) {
        String sql = "SELECT COUNT(*) FROM filmbilgileri WHERE FilmAdi = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FilmAdi);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println(count > 0);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public void updateFilm(String FilmAdi, String FilmTuru, String VizyonTarihi, int Sure, String Yonetmen) {
        if (filmExist(FilmAdi)) {
            String sql = "UPDATE filmbilgileri SET FilmAdi = (?), FilmTuru = (?), VizyonTarihi = (?), Sure = (?), Yonetmen = (?) WHERE FilmAdi = (?)";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                // Güncellenecek değerleri belirleyin ve sorguya parametre olarak ekleyin
                stmt.setString(1, FilmAdi);
                stmt.setString(2, FilmTuru);
                stmt.setString(3,  VizyonTarihi);
                stmt.setInt(4, Sure);
                stmt.setString(5, Yonetmen);
                stmt.setString(6, FilmAdi);
                
                stmt.executeUpdate();

                System.out.println("Film güncellendi.");
            } catch (SQLException ex) {
                Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Film bulunamadı.");
        }

    }
    
    
    



}

