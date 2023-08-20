package org.example.entity;

import java.net.URI;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;


    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(URI caminhoArquivo){
        leituraRetorno.lerArquivo(caminhoArquivo);
    };

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
