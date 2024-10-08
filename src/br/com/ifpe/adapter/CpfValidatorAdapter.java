package br.com.ifpe.adapter;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;


public class CpfValidatorAdapter {

    private String formaterCPF(String cpf) {
        Formatter formatter = new CPFFormatter();
        return formatter.format(cpf);
    }

    public boolean validateCPF(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
           cpfValidator.assertValid(formaterCPF(cpf));
           return true;
        } catch (InvalidStateException e) {
            System.out.println("CPF Invalid" + e.getInvalidMessages());
            return false;
        }
    }
}

