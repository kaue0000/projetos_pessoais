package com.musica.modulo;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Artista extends Pessoa {
    private Set<Musica> musicas = new LinkedHashSet<>();
    
    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }
    public Set<Musica> getMusicas() {
        return musicas;
    }

    public void gravarMusica(Musica musica) {
        getMusicas().add(musica);
    }
    public void apagarMusica(Musica musica) {
        Iterator<Musica> iterator = getMusicas().iterator();
        while(iterator.hasNext()) {
            Musica proximaMusica = iterator.next();
            if (musica.getNome().equalsIgnoreCase(proximaMusica.getNome())) {
                iterator.remove();
            }
        }
    }
}
