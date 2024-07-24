package cinemaautomation;


public class Tickets {
    private int BiletID;
    private String MusteriAdi;
    private String FilmAdi;
    private int Salon;
    private String FilmSaati;
    private int BiletFiyatı;

    public Tickets(int BiletID, String MusteriAdi, String FilmAdi, int Salon, String FilmSaati, int BiletFiyatı) {
        this.BiletID = BiletID;
        this.MusteriAdi = MusteriAdi;
        this.FilmAdi = FilmAdi;
        this.Salon = Salon;
        this.FilmSaati = FilmSaati;
        this.BiletFiyatı = BiletFiyatı;
    }

    
    /**
     * @return the BiletID
     */
    public int getBiletID() {
        return BiletID;
    }

    /**
     * @param BiletID the BiletID to set
     */
    public void setBiletID(int BiletID) {
        this.BiletID = BiletID;
    }

    /**
     * @return the MusteriAdi
     */
    public String getMusteriAdi() {
        return MusteriAdi;
    }

    /**
     * @param MusteriAdi the MusteriAdi to set
     */
    public void setMusteriAdi(String MusteriAdi) {
        this.MusteriAdi = MusteriAdi;
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
     * @return the Salon
     */
    public int getSalon() {
        return Salon;
    }

    /**
     * @param Salon the Salon to set
     */
    public void setSalon(int Salon) {
        this.Salon = Salon;
    }

    /**
     * @return the FilmSaati
     */
    public String getFilmSaati() {
        return FilmSaati;
    }

    /**
     * @param FilmSaati the FilmSaati to set
     */
    public void setFilmSaati(String FilmSaati) {
        this.FilmSaati = FilmSaati;
    }

    /**
     * @return the BiletFiyatı
     */
    public int getBiletFiyatı() {
        return BiletFiyatı;
    }

    /**
     * @param BiletFiyatı the BiletFiyatı to set
     */
    public void setBiletFiyatı(int BiletFiyatı) {
        this.BiletFiyatı = BiletFiyatı;
    }

   }
