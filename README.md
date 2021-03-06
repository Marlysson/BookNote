##Aplicativo de leituras feito em Android.

#### Nome: __BookNote__

####__Projeto final da disciplina de Programação Orientada a Objetos__

- Aplicação dos conceitos vistos na disciplina;
	- Orientação a Objetos
	- Atributos e Métodos
	- Métodos Acessores
	- Atributos de visibilidade
	- Padrões ( Composição, Strategy Factory)
	- Banco de dados usando JDBC

- Integrações
	- Transição do modo Orientado a Objetos para o Relacional, relacionando as composições das classes com os relacionamentos entre as tabelas no banco de dados.

####__Ciclo de Desenvolvimento__
1. Levantamento de Requisitos
	 - Nessa fase foi recebido os requisitos da aplicaçao que teria que ser feita e todas as informações adicionais.
	 ![Requisitos](Documentação/Requisitos.jpg "Requisitos")
	 
2. Análise de Projeto
	 - Nessa fase foi pensado o modo de relacionamento inicial das classes e como seria feita a implementação.
	 - Criado os relacionamentos no banco de dados baseado no relacionamento de classes.
	 
	 - __Diagrama  de Classes__
	 ![Diagrama  de classes](Documentação/Diagrama%20de%20Classes.png "Análise")
	 
	 - __Relacionamento Banco de Dados__
	 ![Relacionamento do Banco de dados](Documentação/Modelo%20Relacional.png "Banco de dados") 

	 - __Estrutura DAO__
		![Relacionamento do Banco de dados](Documentação/Diagrama%20DAO.png "DAO") 


#####Linguagens e Banco de dados utilizados:
 - Linguagem: Java
 - Banco : SQLite
 - Tecnologia : Mobile (Android)

3. Projeto
	- Implementação dos DAO (Data Access Object)
		- 1 DAO para cada entidade de classe, cada uma manuseando seus dados.
		- LeitorDAO, LeituraDAO, LivroDAO, CapituloDAO, AnotacaoDAO;

4. Implementação
	- Nessa fase é a parte de aplicabilidade para tornar a aplicação apresentável na plataforma _android_, usando suas apis e seus recursos.

	####Recursos
	- Activitys
		- CadastraLeitor
		- CadastraLivro

   - Layout
	   - Cadastralivro
		- Cadastroinicial 