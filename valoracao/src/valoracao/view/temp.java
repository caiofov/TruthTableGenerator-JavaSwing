// bExcluirTabela.addActionListener(new ActionListener() {
    
//     public void actionPerformed(ActionEvent e){
//         System.out.println("Abrindo opções de exclusão de tabela...");
//         LeTabelas leitor2 = new LeTabelas();
//         ArrayList<Tabela> lista = leitor2.getLista();
//         int x = -1;
//         String num_tabela = (String)JOptionPane.showInputDialog(null, "Qual tabela deseja excluir? ", "Excluir Tabela", JOptionPane.QUESTION_MESSAGE, null, null, "Digite o número da tabela");
        

//         while(x < 0 || x > lista.size()-1){
//             System.out.println("Insira um número válido");
//             JOptionPane.showMessageDialog(null, "Digite um número válido.", "Número Inválido", JOptionPane.ERROR_MESSAGE);
//             num_tabela = (String)JOptionPane.showInputDialog(null, "Qual tabela deseja excluir? ", "Excluir Tabela", JOptionPane.QUESTION_MESSAGE, null, null, "Digite o número da tabela");
//             x = Integer.parseInt(num_tabela) - 1;
            
//         }
        
//         ExcluirTabela exc = new ExcluirTabela(lista, x);
        
//         exc.excluirTab();
            
//         // ATUALIZAR A TELA DE TABELAS SALVAS...
//         leitor = new LeTabelas();
//         TelaTabelasSalvas.this.dispose();
//         new TelaTabelasSalvas();
        
        
//     }
// });