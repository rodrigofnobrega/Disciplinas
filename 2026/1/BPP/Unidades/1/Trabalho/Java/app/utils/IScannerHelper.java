package app.utils;

import java.util.Scanner;

public interface IScannerHelper {
    String lerEntradaTexto(String mensagem);
    int lerEntradaInteiro(String mensagem);
    void fecharScanner();
}
