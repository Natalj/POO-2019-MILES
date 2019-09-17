import com.sun.deploy.panel.AbstractRadioPropertyGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {

    ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Automovel> listaAutomoveis = new ArrayList<>();
    ArrayList<Venda> listaVendas = new ArrayList<>();
    ArrayList<Gerente> listaGerentes = new ArrayList<>();
    ArrayList<Badeco> listaBadecos = new ArrayList<>();

    public static void main(String args[]){
        System.out.println("#!!# Garagem do Noel #!!#");

        Principal principal = new Principal();
        principal.menuPrincipal();
    }

    public void menuPrincipal(){

        Scanner sc = new Scanner(System.in);

        System.out.println("> Menu Principal <");
        System.out.println("1 - Funcionario");
        System.out.println("2 - Cliente");
        System.out.println("3 - Automovel");
        System.out.println("4 - Vendas");
        System.out.println("0 - Sair");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                menuFuncionario();
                break;
            case 2:
                menuCliente();
                break;
            case 3:
                menuAutomovel();
                break;
            case 4:
                menuVendas();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuPrincipal();
                break;
        }
    }

    public void menuFuncionario(){

        Scanner sc = new Scanner(System.in);

        System.out.println("> Menu Funcionario <");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                cadastroFuncionario();
                break;
            case 2:
                listarFuncionario();
                break;
            case 3:
                buscarFuncionario();
                break;
            case 4:
                alterarFuncionario();
                break;
            case 5:
                removeFuncionario();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuFuncionario();
                break;
        }

        menuFuncionario();
    }

    public void cadastroFuncionario(){

        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);
        int tipoFuncionario = 0;

        Funcionario funcionario = new Funcionario();

        System.out.println("> Cadastro de Funcionario <");
        System.out.println("Qual o tipo de Funcionario ? (1- Gerente 2- Badeco 3-Funcionario Comum)");
        tipoFuncionario = sci.nextInt();

        if(tipoFuncionario != 1 && tipoFuncionario != 2 && tipoFuncionario != 3){
            System.out.println("O tipo informado e invalido ou nao existe! Tente novamente.");
            cadastroFuncionario();
        }else{
            System.out.println("Informe o nome: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("Informe o CPF: ");
            funcionario.setCpf(sc.nextLine());

            System.out.println("Informe o endereco: ");
            funcionario.setEndereco(sc.nextLine());

            System.out.println("Informe o telefone: ");
            funcionario.setTelefone(sc.nextLine());

            try {
                System.out.println("Informe a data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                funcionario.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Informe o codigo: ");
            funcionario.setCodigo(sci.nextInt());

            System.out.println("Informe o usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("Informe a senha: ");
            funcionario.setSenha(sc.nextLine());

            if(tipoFuncionario == 1){
                Gerente gerente = new Gerente();

                gerente.mapFuncionarioToGerente(funcionario);

                System.out.println("Informe a matricula: ");
                gerente.setMatricula(sc.nextLine());

                System.out.println("Informe o departamento: ");
                gerente.setDepartamento(sc.nextLine());

                System.out.println("Informe o salario: ");
                gerente.setSalario(sci.nextFloat());

                listaGerentes.add(gerente);

                funcionario = gerente;
            }else if(tipoFuncionario == 2){
                Badeco badeco = new Badeco();

                badeco.mapFuncionarioToBadeco(funcionario);

                System.out.println("Informe a funcao: ");
                badeco.setFuncao(sc.nextLine());

                System.out.println("Informe o salario: ");
                badeco.setSalario(sci.nextFloat());

                listaBadecos.add(badeco);

                funcionario = badeco;
            }else {
                System.out.println("Informe o salario: ");
                funcionario.setSalario(sci.nextFloat());
            }

            listaFuncionarios.add(funcionario);
        }
    }

    public void listarFuncionario(){

        System.out.println("> Lista de Funcionarios <");
        for(Funcionario f: listaFuncionarios){
            System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            System.out.println("Nome: " + f.getNome());
            System.out.println("Telefone: " + f.getTelefone());
            System.out.println("Codigo: " + f.getCodigo());
            System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
        }
    }

    public void buscarFuncionario(){

        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("> Busca de Funcionários <");
        System.out.println("Informe o codigo do funcionario:");
        int codFunc = sc.nextInt();

        for(Funcionario f: listaFuncionarios){
            if (f.getCodigo() == codFunc){
                find = true;
                System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
                System.out.println("Nome: " + f.getNome());
                System.out.println("CPF: " + f.getCpf());
                System.out.println("Endereco: " + f.getEndereco());
                System.out.println("Telefone: " + f.getTelefone());
                System.out.println("Data de Nascimento: " + f.getDt_nascimento());
                System.out.println("Codigo: " + f.getCodigo());
                System.out.println("Usuario: " + f.getUsuario());
                System.out.println("Senha: " + f.getSenha());
                System.out.println("Salario: " + f.calculaSalario());
                if(f.calculaSalario() >= f.getSalario()*1.5f){
                    System.out.println("~ # Este Funcionario e um gerente");
                    for(Gerente g: listaGerentes){
                        System.out.println("Matricula: " + g.getMatricula());
                        System.out.println("Departamento: " + g.getDepartamento());
                    }
                }else if(f.calculaSalario() <= f.getSalario()*0.8f){
                    System.out.println("~ # Este Funcionario e um badeco");
                    for(Badeco b: listaBadecos){
                        System.out.println("Funcao: " + b.getFuncao());
                    }
                }
                System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            }
        }
        if(find == false){
            System.out.println("Funcionario nao encontrado! Tente Novamente.");
            menuFuncionario();
        }
    }

    public void alterarFuncionario(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        boolean find= false;

        System.out.println("> Alteracao de funcionario <");

        System.out.println("Informe o codigo do funcionario: ");
        int codFunc = sci.nextInt();

        for(Funcionario funcionario: listaFuncionarios){
            if(codFunc == funcionario.getCodigo()) {

                find = true;

                System.out.println("Informe o nome: ");
                funcionario.setNome(sc.nextLine());

                System.out.println("Informe o CPF: ");
                funcionario.setCpf(sc.nextLine());

                System.out.println("Informe o endereco: ");
                funcionario.setEndereco(sc.nextLine());

                System.out.println("Informe o telefone: ");
                funcionario.setTelefone(sc.nextLine());

                try {
                    System.out.println("Informe a data de nascimento: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    funcionario.setDt_nascimento(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Informe o codigo: ");
                funcionario.setCodigo(sci.nextInt());

                System.out.println("Informe o usuario: ");
                funcionario.setUsuario(sc.nextLine());

                System.out.println("Informe a senha: ");
                funcionario.setSenha(sc.nextLine());
            }
        }

        if(!find){
            System.out.println("Funcionario nao encontrado! Tente novamente.");
            menuFuncionario();
        }
    }

    public void removeFuncionario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("> Exclusão de Funcionarios <");
        System.out.println("Informe o codigo do funcionário:");
        int codFunc = sc.nextInt();

        List<Funcionario> removeFuncionario = new ArrayList<>();

        for(Funcionario f: listaFuncionarios){
            if(f.getCodigo() == codFunc){
                removeFuncionario.add(f);
            }
        }

        listaFuncionarios.removeAll(removeFuncionario);
    }

    public void menuCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> Menu Cliente <");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch(op){
            case 1:
                cadastrarCliente();
                break;
            case 2:
                listarCliente();
                break;
            case 3:
                buscarCliente();
                break;
            case 4:
                alterarCliente();
                break;
            case 5:
                removeCliente();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuCliente();
                break;
        }

        menuCliente();
    }

    public void cadastrarCliente(){
        Cliente cliente = new Cliente();

        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("Informe o CPF: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("Informe o endereco: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("Informe o telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            System.out.println("Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Informe o codigo:");
        cliente.setCodigo(sci.nextInt());

        listaClientes.add(cliente);
    }

    public void listarCliente(){
        System.out.println("> Lista de Clientes <");
        for(Cliente c: listaClientes){
            System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Codigo: " + c.getCodigo());
            System.out.println("Endereco: " + c.getEndereco());
            System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
        }
    }

    public void buscarCliente(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("> Busca de Cliente <");
        System.out.println("Informe o nome do cliente: ");
        String bscCliente = sc.nextLine();

        for(Cliente c: listaClientes){
            if(c.getNome().equals(bscCliente)){

                find = true;

                System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Endereco: " + c.getEndereco());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("Data de Nascimento: " + c.getDt_nascimento());
                System.out.println("Codigo: " + c.getCodigo());
                System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            }
        }
        if(!find){
            System.out.println("Cliente nao encontrado! Tente novamente.");
            menuCliente();
        }
    }

    public void alterarCliente(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        boolean find= false;

        System.out.println("# Alteracao de cliente");

        System.out.println(">Informe o codigo do cliente:");
        int codCliente = sc.nextInt();
        for(Cliente cliente: listaClientes){
            if(codCliente == cliente.getCodigo()){

                find = true;

                System.out.println("Informe o nome: ");
                cliente.setNome(sc.nextLine());

                System.out.println("Informe o CPF: ");
                cliente.setCpf(sc.nextLine());

                System.out.println("Informe o endereco: ");
                cliente.setEndereco(sc.nextLine());

                System.out.println("Informe o telefone: ");
                cliente.setTelefone(sc.nextLine());

                try {
                    System.out.println("Informe a data de nascimento: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    cliente.setDt_nascimento(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Informe o codigo:");
                cliente.setCodigo(sci.nextInt());
            }
        }

        if(!find){
            System.out.println("Cliente nao encontrado! Tente novamente.");
            menuCliente();
        }
    }

    public void removeCliente(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("> Exclusão de Cliente <");
        System.out.println("Informe o codigo do cliente:");
        int codCliente = sc.nextInt();

        List<Cliente> removeCliente = new ArrayList<>();

        for(Cliente c: listaClientes){
            if(c.getCodigo() == codCliente){
                find = true;
                removeCliente.add(c);
            }
        }

        if(!find){
            System.out.println("Cliente nao encontrado! Tente novamente.");
            menuCliente();
        }

        listaClientes.removeAll(removeCliente);
    }

    public void menuAutomovel(){

        Scanner sc = new Scanner(System.in);

        System.out.println("> Menu Automovel <");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Buscar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                cadastroAutomovel();
                break;
            case 2:
                listarAutomovel();
                break;
            case 3:
                buscarAutomovel();
                break;
            case 4:
                alterarAutomovel();
                break;
            case 5:
                removeAutomovel();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuAutomovel();
                break;
        }

        menuAutomovel();
    }

    public void cadastroAutomovel(){
        Scanner sc = new Scanner(System.in);

        Automovel automovel = new Automovel();

        System.out.println("> Cadastro de Automovel <");
        System.out.println("Informe o modelo: ");
        automovel.setNome_modelo(sc.nextLine());

        System.out.println("Informe a marca: ");
        automovel.setNome_marca(sc.nextLine());

        System.out.println("Informe o tipo (Carro ou Moto): ");
        automovel.setTipo(sc.nextLine());

        try {
            System.out.println("Informe o ano de fabricação: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.setAno_fab(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Informe o ano do modelo: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.setAno_modelo(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Informe a cor: ");
        automovel.setCor(sc.nextLine());

        System.out.println("Informe o chassi: ");
        automovel.setChassi(sc.nextLine());

        System.out.println("Informe a placa: ");
        automovel.setPlaca(sc.nextLine());

        System.out.println("Informe a quillometragem: ");
        automovel.setKm(sc.nextFloat());

        System.out.println("Informe o valor: ");
        automovel.setValor(sc.nextFloat());

        listaAutomoveis.add(automovel);
    }

    public void listarAutomovel(){
        System.out.println("> Lista de Automoveis <");
        for(Automovel au: listaAutomoveis){
            System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            System.out.println("Modelo: " + au.getNome_modelo());
            System.out.println("Placa: " + au.getPlaca());
            System.out.println("Cor: " + au.getCor());
            System.out.println("Quilometragem: " + au.getKm());
            System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
        }
    }

    public void buscarAutomovel(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("# Busca de automovel");
        System.out.println("Informe a placa do automovel:");
        String bscPlaca = sc.nextLine();

        for(Automovel au: listaAutomoveis){
            if(au.getPlaca().equals(bscPlaca)){

                find = true;

                System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
                System.out.println("Modelo: " + au.getNome_modelo());
                System.out.println("Marca: " + au.getNome_marca());
                System.out.println("Placa: " + au.getPlaca());
                System.out.println("Valor: R$" + au.getValor());
                System.out.println("Quilometragem: " + au.getKm() + "KM");
                System.out.println("Chassi: " + au.getChassi());
                System.out.println("Cor: " + au.getCor());
                System.out.println("Tipo: " + au.getTipo());
                System.out.println("Ano de Fabricação: " + au.getAno_fab());
                System.out.println("Ano do Modelo: " + au.getAno_modelo());
                System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            }
        }
        if(!find){
            System.out.println("Veiculo nao encontrado! Tente novamente.");
            menuAutomovel();
        }
    }

    public void alterarAutomovel(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("# Alteracao de automovel");

        System.out.println("Informe a placa do automovel:");
        String placaAuto = sc.nextLine();

        for(Automovel automovel: listaAutomoveis){
            if(placaAuto.equals(automovel.getPlaca())){

                find = true;

                System.out.println("Informe o modelo: ");
                automovel.setNome_modelo(sc.nextLine());

                System.out.println("Informe a marca: ");
                automovel.setNome_marca(sc.nextLine());

                System.out.println("Informe o tipo (Carro ou Moto): ");
                automovel.setTipo(sc.nextLine());

                try {
                    System.out.println("Informe o ano de fabricação: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("yyyy").parse(data);
                    automovel.setAno_fab(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                try {
                    System.out.println("Informe o ano do modelo: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("yyyy").parse(data);
                    automovel.setAno_modelo(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Informe a cor: ");
                automovel.setCor(sc.nextLine());

                System.out.println("Informe o chassi: ");
                automovel.setChassi(sc.nextLine());

                System.out.println("Informe a placa: ");
                automovel.setPlaca(sc.nextLine());

                System.out.println("Informe a quillometragem: ");
                automovel.setKm(sc.nextFloat());

                System.out.println("Informe o valor: ");
                automovel.setValor(sc.nextFloat());
            }
        }

        if(!find){
            System.out.println("Automovel nao encontrado! Tente novamente.");
            menuAutomovel();
        }
    }

    public void removeAutomovel(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("> Exclusão de Automovel <");
        System.out.println("Informe a placa do automovel:");
        String bscPlaca = sc.nextLine();

        List<Automovel> removeAutomovel = new ArrayList<>();

        for(Automovel au:listaAutomoveis){
            if(au.getPlaca().equals(bscPlaca)){
                find = true;
                removeAutomovel.add(au);
            }
        }

        if(!find){
            System.out.println("Veiculo nao encontrado! Tente novamente.");
            menuAutomovel();
        }

        listaAutomoveis.removeAll(removeAutomovel);
    }

    public void menuVendas(){

        Scanner sc = new Scanner(System.in);

        System.out.println("> Menu de Vendas <");
        System.out.println("1 - Realizar venda");
        System.out.println("2 - Listar vendas");
        System.out.println("3 - Cancelar venda");
        System.out.println("0 - Voltar");
        System.out.println("Digite sua opção: ");
        int op = sc.nextInt();

        switch (op){
            case 1:
                realizarVenda();
                break;
            case 2:
                listarVendas();
                break;
            case 3:
                cancelarVenda();
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                menuVendas();
                break;
        }

        menuVendas();
    }

    public void realizarVenda(){
        Venda venda = new Venda();

        boolean find= false;
        boolean find2 = false;
        boolean find3 = false;

        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("Informe a placa do automovel: ");
        String bscPlaca = sc.nextLine();

        for(Automovel au: listaAutomoveis){
            if(bscPlaca.equals(au.getPlaca())){
                System.out.println("-> Veiculo escolhido:");
                System.out.println("Placa: " + au.getPlaca());
                find = true;
            }

            if(find == true){
                System.out.println("Informe o codigo do cliente:");
                int codCliente = sci.nextInt();

                for(Cliente cl: listaClientes){
                    if(codCliente == cl.getCodigo()){
                        System.out.println("-> Cliente escolhido:");
                        System.out.println("Codigo: " + cl.getCodigo());
                        find2 = true;
                    }

                    if(find2 == true){
                        System.out.println("Informe o codigo do funcionario: ");
                        int codFunc = sci.nextInt();

                        for(Funcionario fu: listaFuncionarios){
                            if(codFunc == fu.getCodigo()){
                                System.out.println("-> Funcionario escolhido:");
                                System.out.println("Codigo: " + fu.getCodigo());
                                find3 = true;
                            }

                            if(find3 == true){
                                System.out.println("Informe o codigo da venda:");
                                venda.setCodigo(sci.nextInt());

                                try {
                                    System.out.println("Informe a data da venda: ");
                                    String data = sc.nextLine();
                                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    venda.setDt_venda(dt);
                                } catch (ParseException e) {
                                    System.out.println(e.getMessage());
                                }

                                System.out.println("> Possui desconto sobre o valor do veiculo? (1- Sim 0- Nao)");
                                int resposta = sci.nextInt();

                                if(resposta == 1){
                                    System.out.println("Informe o valor do desconto: ");
                                    float desconto = sc.nextFloat();

                                    venda.setValor_venda(au.getValor() - desconto);

                                    System.out.println("-> Valor do veiculo vendido: " + au.getValor());
                                    System.out.println("-> Valor do desconto: " + desconto);
                                    venda.setComissao_venda(venda.getValor_venda()*0.05f);
                                    System.out.println("-> Valor da comissao: " + venda.getComissao_venda());
                                }else{
                                    System.out.println("-> Valor do veiculo vendido: " + au.getValor());
                                    venda.setValor_venda(au.getValor());
                                    venda.setComissao_venda(au.getValor()*0.05f);
                                    System.out.println("-> Valor da comissao: " + venda.getComissao_venda());
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        if(!find || !find2 || !find3){
            System.out.println("Tente Novamente! O veiculo e/ou funcionario/cliente nao foram localizados.");
            menuVendas();
        }

        listaVendas.add(venda);
    }

    public void listarVendas(){
        System.out.println("> Lista de Vendas <");

        for (Venda v : listaVendas) {
            System.out.println("\n#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
            System.out.println("Codigo: " + v.getCodigo());
            System.out.println("Data da venda: " + v.getDt_venda());
            for (Automovel a: listaAutomoveis){
                System.out.println("Placa do automovel: " + a.getPlaca());
            }
            for (Cliente c : listaClientes) {
                System.out.println("Codigo do cliente: " + c.getCodigo());
            }
            for (Funcionario f : listaFuncionarios) {
                System.out.println("Codigo do funcionario: " + f.getCodigo());
            }
            System.out.println("Valor de venda: " + v.getValor_venda());
            System.out.println("#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#");
        }
    }

    public void cancelarVenda(){
        Scanner sc = new Scanner(System.in);

        boolean find= false;

        System.out.println("Informe o codigo da venda:");
        int bscVenda = sc.nextInt();

        List<Venda> cancelaVenda = new ArrayList<>();

        for(Venda v: listaVendas){
            if(bscVenda == v.getCodigo()){
                find = true;
                cancelaVenda.add(v);
            }
        }

        if(!find){
            System.out.println("Venda nao localizada! Tente novamente.");
            menuVendas();
        }

        listaVendas.removeAll(cancelaVenda);
    }
}