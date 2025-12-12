import com.musica.modulo.Artista;
import com.musica.modulo.Musica;
import com.musica.modulo.Usuario;

public class App {
    public static void main(String[] args)  {
        Artista artista = new Artista();

        artista.setNome("Rammstein");
        artista.setIdade(25);
        artista.setDataNascimento(null);
        artista.setEmail("rammstein@gmail.com");

        Musica musica = new Musica();

        musica.setArtista(artista);
        musica.setNome("Deutschland");
        musica.setGenero("Metal");
        musica.setGravadora("Seila");
        musica.setLinguagem("Alemão");
        musica.setSegundos(10);

        Musica musica2 = new Musica();

        musica2.setArtista(artista);
        musica2.setNome("Du Hast");
        musica2.setGenero("Metal");
        musica2.setGravadora("Seila");
        musica2.setLinguagem("Alemão");
        musica2.setSegundos(10);

        artista.gravarMusica(musica);

        //System.out.println(artista.getMusicas());

        Usuario usuario = new Usuario();

        usuario.adicionarAoFavoritos(musica);
        usuario.adicionarAoFavoritos(musica2);

        //System.out.println("Favoritos: ");
        //System.out.println(usuario.getMusicasFavoritas());

        usuario.removerDosFavoritos(musica2);

        //System.out.println(usuario.getMusicasFavoritas());

        usuario.criarPlaylist("KAMES PT.2");

        usuario.adicionarMusicarPlaylist("KAMES PT.2", musica2);
        usuario.adicionarMusicarPlaylist("KAMES PT.2", musica);
        usuario.tocarPlaylist("KAMES PT.2");

    }
}
