
package telaa;


public class CPF {
    
    public void validaCPF(String cpf) throws ExcecaoCPFInvalido{
	
		int i1 = Character.getNumericValue(cpf.charAt(0));
		int i2 = Character.getNumericValue(cpf.charAt(1)); // CONVERTER OS CARACTERES DA STRING CPF,
		int i3 = Character.getNumericValue(cpf.charAt(2)); // PARA INTEIROS, PERMITINDO EFETUAR CONTAS
		int i4 = Character.getNumericValue(cpf.charAt(3));
		int i5 = Character.getNumericValue(cpf.charAt(4));
		int i6 = Character.getNumericValue(cpf.charAt(5));
		int i7 = Character.getNumericValue(cpf.charAt(6));
		int i8 = Character.getNumericValue(cpf.charAt(7));
		int i9 = Character.getNumericValue(cpf.charAt(8));
		int i10 = Character.getNumericValue(cpf.charAt(9));
		int i11 = Character.getNumericValue(cpf.charAt(10));
		
		int soma1 = (i1 * 10) + (i2 * 9) + (i3 * 8) + (i4 * 7) + (i5 * 6) + (i6 * 5) + (i7 * 4) + (i8 * 3) + (i9 * 2);
		int resto = soma1 % 11;
		
		if ((resto == 1 || resto == 0) && (i10 != 0)){
			throw new ExcecaoCPFInvalido("CPF INVÁLIDO : ",cpf);
		}
		if ((resto > 1) && (i10 != (11-resto))){
			throw new ExcecaoCPFInvalido("CPF INVÁLIDO : ",cpf);
		}
		
		soma1 = (i1 * 11) + (i2 * 10) + (i3 * 9) + (i4 * 8) + (i5 * 7) + (i6 * 6) + (i7 * 5) + (i8 * 4) + (i9 * 3) + (i10 * 2);
		resto = soma1 % 11;
		
		if ((resto == 1 || resto == 0) && (i11 != 0)){
			throw new ExcecaoCPFInvalido("CPF INVÁLIDO : ",cpf);
		}
		if ((resto > 1) && (i11 != (11-resto))){
			throw new ExcecaoCPFInvalido("CPF INVÁLIDO : ",cpf);
		}
		
	}
    
}
