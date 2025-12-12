package com.musica.modulo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Usuario extends Pessoa {
    private Set<Musica> musicasFavoritas = new LinkedHashSet<>();
    private Set<Musica> musicasBloqueadas = new HashSet<>();
    private Set<Artista> artistasFavoritos = new LinkedHashSet<>();
    private Set<Artista> artistasBloqueados = new HashSet<>();
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public void setMusicasFavoritas(Set<Musica> musicasFavoritas) {
        this.musicasFavoritas = musicasFavoritas;
    }
    public Set<Musica> getMusicasFavoritas() {
        return musicasFavoritas;
    }
    public void setMusicasBloqueadas(Set<Musica> musicasBloqueadas) {
        this.musicasBloqueadas = musicasBloqueadas;
    }
    public Set<Musica> getMusicasBloqueadas() {
        return musicasBloqueadas;
    }
    public void setArtistasFavoritos(Set<Artista> artistasFavoritos) {
        this.artistasFavoritos = artistasFavoritos;
    }
    public Set<Artista> getArtistasFavoritos() {
        return artistasFavoritos;
    }
    public void setArtistasBloqueados(Set<Artista> artistasBloqueados) {
        this.artistasBloqueados = artistasBloqueados;
    }
    public Set<Artista> getArtistasBloqueados() {
        return artistasBloqueados;
    }
    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }
    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void adicionarAoFavoritos(Musica musica) {
        getMusicasFavoritas().add(musica);
    }
    public void adicionarAoFavoritos(Artista artista) {
        getArtistasFavoritos().add(artista);
    }
    public void adicionarAoBloqueados(Musica musica) {
        getMusicasBloqueadas().add(musica);
    }
    public void adicionarAoBloqueados(Artista artista) {
        getArtistasBloqueados().add(artista);
    }

    public void removerDosFavoritos(Musica musica) {
        Iterator<Musica> iterator = getMusicasFavoritas().iterator();
        while(iterator.hasNext()) {
            Musica proximaMusica = iterator.next();
            if (proximaMusica.getNome().equalsIgnoreCase(musica.getNome())) {
                iterator.remove();
            }
        }
    }
    public void removerDosFavoritos(Artista artista) {
        Iterator<Artista> iterator = getArtistasFavoritos().iterator();
        while(iterator.hasNext()) {
            Artista proximoArtista = iterator.next();
            if (proximoArtista.getNome().equalsIgnoreCase(artista.getNome())) {
                iterator.remove();
            }
        }
    }
    public void removerDosBloqueados(Musica musica) {
        Iterator<Musica> iterator = getMusicasBloqueadas().iterator();
        while(iterator.hasNext()) {
            Musica proximaMusica = iterator.next();
            if (proximaMusica.getNome().equalsIgnoreCase(musica.getNome())) {
                iterator.remove();
            }
        }
    }
    public void removerDosBloqueados(Artista artista) {
        Iterator<Artista> iterator = getArtistasBloqueados().iterator();
        while(iterator.hasNext()) {
            Artista proximoArtista = iterator.next();
            if (proximoArtista.getNome().equalsIgnoreCase(artista.getNome())) {
                iterator.remove();
            }
        }
    }

    public void visualizarMusicasFavoritas() {
        System.out.println(getMusicasFavoritas());
    }
    public void visualizarArtistasFavoritos() {
        System.out.println(getArtistasFavoritos());
    }
    public void visualizarMusicasBloqueadas() {
        System.out.println(getMusicasBloqueadas());
    }
    public void visualizarArtistasBloqueados() {
        System.out.println(getArtistasBloqueados());
    }

    public void criarPlaylist(String nome) {
        getPlaylists().add(new Playlist(nome));
    }
    public void adicionarMusicarPlaylist(String nomePlaylist, Musica musica) {
        Playlist playlist = buscarPlaylist(nomePlaylist);
        if (playlist != null) playlist.adicionarMusica(musica);
    }
    public void removerMusicaPlaylist(String nomePlaylist, Musica musica) {
        Playlist playlist = buscarPlaylist(nomePlaylist);
        if (playlist != null) playlist.removerMusica(musica);
    }
    public void tocarPlaylist(String nomePlaylist) {
        Playlist playlist = buscarPlaylist(nomePlaylist);
        if (playlist != null) playlist.tocarPlaylist();
    }
    public Playlist buscarPlaylist(String nomePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) 
                return playlist;
        }
        return null;
    }
}
    