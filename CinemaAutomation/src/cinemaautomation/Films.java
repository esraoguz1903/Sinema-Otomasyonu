package cinemaautomation;

import java.util.Date;


public class Films {
    private int FilmID;
    private String FilmAdi;
    private String FilmTuru;
    private Date VizyonTarihi;
    private int Sure;
    private String Yonetmen;

    public Films(int FilmID, String FilmAdi, String FilmTuru, Date VizyonTarihi, int Sure, String Yonetmen) {
        this.FilmID = FilmID;
        this.FilmAdi = FilmAdi;
        this.FilmTuru = FilmTuru;
        this.VizyonTarihi = VizyonTarihi;
        this.Sure = Sure;
        this.Yonetmen = Yonetmen;
    }
    
    

    /**
     * @return the FilmID
     */
    public int getFilmID() {
        return FilmID;
    }

    /**
     * @param FilmID the FilmID to set
     */
    public void setFilmID(int FilmID) {
        this.FilmID = FilmID;
    }

    /**
     * @return the FilmAdi
     */
    public String getFilmAdi() {
        return FilmAdi;
    }

    /**
     * @param FilmAdi the FilmAdi to set
     */
    public void setFilmAdi(String FilmAdi) {
        this.FilmAdi = FilmAdi;
    }

    /**
     * @return the FilmTuru
     */
    public String getFilmTuru() {
        return FilmTuru;
    }

    /**
     * @param FilmTuru the FilmTuru to set
     */
    public void setFilmTuru(String FilmTuru) {
        this.FilmTuru = FilmTuru;
    }

    /**
     * @return the VizyonTarihi
     */
    public Date getVizyonTarihi() {
        return VizyonTarihi;
    }

    /**
     * @param VizyonTarihi the VizyonTarihi to set
     */
    public void setVizyonTarihi(Date VizyonTarihi) {
        this.VizyonTarihi = VizyonTarihi;
    }

    /**
     * @return the Sure
     */
    public int getSure() {
        return Sure;
    }

    /**
     * @param Sure the Sure to set
     */
    public void setSure(int Sure) {
        this.Sure = Sure;
    }

    /**
     * @return the Yonetmen
     */
    public String getYonetmen() {
        return Yonetmen;
    }

    /**
     * @param Yonetmen the Yonetmen to set
     */
    public void setYonetmen(String Yonetmen) {
        this.Yonetmen = Yonetmen;
    }
    
    
}

