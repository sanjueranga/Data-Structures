public class Artist {

    private int artistId;
    private int number_of_songs;

    public Artist(int id, int songs) {
        this.artistId = id;
        this.number_of_songs = songs;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getNumber_of_songs() {
        return number_of_songs;
    }

}
