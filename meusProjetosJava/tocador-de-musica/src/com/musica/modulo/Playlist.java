package com.musica.modulo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        setNome(nome);
    }
    public Playlist() {}

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    public List<Musica> getMusicas() {
        return musicas;
    }
    protected void adicionarMusica(Musica musica) {
        this.getMusicas().add(musica);
    }
    protected void removerMusica(Musica musica) {
        Iterator<Musica> iterator = getMusicas().iterator();
        while (iterator.hasNext()) {
            Musica proxima = iterator.next();
            if (proxima.equals(musica)) 
                iterator.remove();
        }
    }
    protected void tocarPlaylist() {
        Iterator<Musica> iterator = getMusicas().iterator();
        while (iterator.hasNext()) {
            Musica proxima = iterator.next();

            System.out.println("Tocando: " + proxima.getNome() + " - " + proxima.getArtista().getNome());

            try {
                tocarMusica(proxima);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    protected void tocarMusica(Musica musica) throws InterruptedException {
        Integer contagem = 0;
        while(contagem <= musica.getSegundos()) {
                System.out.print("\r" + contagem + "s");
                if (contagem > 60)
                    System.out.print("\r" + contagem + "s");
            contagem = contagem + 1;
            Thread.sleep(1000);
        }
        System.out.println();
    }
}
