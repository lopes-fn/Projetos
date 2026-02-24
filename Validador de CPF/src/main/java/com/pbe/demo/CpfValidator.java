public class CpfValidator {

    public static boolean isValid(String cpf) {

        if (cpf == null) return false;

        // Remove pontuação
        cpf = cpf.replaceAll("[^0-9]", "");

        // Deve ter 11 dígitos
        if (cpf.length() != 11) return false;

        // Evita CPFs com todos os números iguais (ex: 11111111111)
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }

            int resto = (soma * 10) % 11;
            if (resto == 10) resto = 0;

            if (resto != Character.getNumericValue(cpf.charAt(9)))
                return false;

            // Segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }

            resto = (soma * 10) % 11;
            if (resto == 10) resto = 0;

            if (resto != Character.getNumericValue(cpf.charAt(10)))
                return false;

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}