import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();
        System.out.print("Digite a chave: ");
        String chave = scanner.nextLine();

        String mensagemCifrada = cifrar(mensagem, chave);
        System.out.println("Mensagem cifrada: " + mensagemCifrada);

        String mensagemDecifrada = decifrar(mensagemCifrada, chave);
        System.out.println("Mensagem decifrada: " + mensagemDecifrada);
    }

    // Cifra uma mensagem usando a cifra de César
    public static String cifrar(String mensagem, String chave) {
        StringBuilder mensagemCifrada = new StringBuilder();
        mensagem = mensagem.toLowerCase();
        chave = chave.toLowerCase();

        for (int i = 0; i < mensagem.length(); i++) {
            // Pega a letra da mensagem
            char letraMensagem = mensagem.charAt(i);
            // A chave é repetida até que ela tenha o mesmo tamanho da mensagem
            char letraChave = chave.charAt(i % chave.length());

            if (Character.isLetter(letraMensagem)) {
                // Pega a posição da letra da mensagem
                int posicaoMensagem = letraMensagem - 'a';
                int posicaoChave = letraChave - 'a';

                int novaPosicao = (posicaoMensagem + posicaoChave) % 26;
                char novaLetra = (char) ('a' + novaPosicao);

                mensagemCifrada.append(novaLetra);
            } else {
                mensagemCifrada.append(letraMensagem);
            }
        }

        return mensagemCifrada.toString();
    }

    public static String decifrar(String mensagemCifrada, String chave) {
        StringBuilder mensagemDecifrada = new StringBuilder();
        mensagemCifrada = mensagemCifrada.toLowerCase();
        chave = chave.toLowerCase();

        for (int i = 0; i < mensagemCifrada.length(); i++) {
            char letraMensagemCifrada = mensagemCifrada.charAt(i);
            char letraChave = chave.charAt(i % chave.length());

            if (Character.isLetter(letraMensagemCifrada)) {
                int posicaoMensagemCifrada = letraMensagemCifrada - 'a';
                int posicaoChave = letraChave - 'a';

                int novaPosicao = (posicaoMensagemCifrada - posicaoChave + 26) % 26;
                char novaLetra = (char) ('a' + novaPosicao);

                mensagemDecifrada.append(novaLetra);
            } else {
                mensagemDecifrada.append(letraMensagemCifrada);
            }
        }

        return mensagemDecifrada.toString();
    }
}