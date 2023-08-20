package org.example.entity;

import java.net.URI;
import java.util.List;

public interface LeituraRetorno {
    public List<Boleto> lerArquivo(URI caminhoArquivo);

}
