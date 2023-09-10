public class Genere {
    protected int ID;
    protected Artist[] artists = new Artist[10];
    protected int hourly_rate;
    protected int artist_count = 0;

    protected void addWork(int artist_id, int no_of_songs) {
        this.artists[this.artist_count] = new Artist(artist_id, no_of_songs);
        this.artist_count++;
    }

    protected Artist geArtist(int artist_id) {
        return this.artists[artist_id];
    }

    protected int getPayment(int artist_no) {

        for (int i = 0; i < this.artist_count; i++) {
            if (this.artists[i].getArtistId() == artist_no) {
                return this.artists[i].getNumber_of_songs() * hourly_rate;
            }
        }
        return 0;
    }
}
