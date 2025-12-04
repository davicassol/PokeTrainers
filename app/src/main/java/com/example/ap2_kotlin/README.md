🔴 PokéTrainers - Gerenciador de Personagens

Projeto Avaliativo de Desenvolvimento Android (Kotlin)
Este aplicativo é um gerenciador de personagens do universo Pokémon (Trainers), desenvolvido como parte da avaliação acadêmica da disciplina de Desenvolvimento Mobile. O projeto implementa um CRUD completo (Create, Read, Update, Delete) com persistência de dados local, seguindo a arquitetura MVVM e utilizando os componentes modernos do Android Jetpack.

📱 Funcionalidades (CRUD)
O aplicativo permite:
Listar (Read): Exibição de todos os personagens cadastrados em uma RecyclerView customizada.
Detalhar (Read): Visualização completa das informações do personagem ao clicar em um item.
Cadastrar (Create): Formulário para inserção de novos treinadores, região e Pokémon principal.
Editar (Update): Possibilidade de alterar dados de um personagem existente através do botão de edição na tela de detalhes.
Excluir (Delete): Remoção de um personagem do banco de dados através de um clique longo (long press) na lista, com diálogo de confirmação.

🎨 Design & UX
O aplicativo possui uma interface temática inspirada na Pokédex Clássica:
Paleta de Cores: Vermelho Pokédex, botões em azul "vidro" e telas internas em verde retro.
Componentes Visuais: Uso de CardView estilizados, FloatingActionButton e layouts responsivos.
Feedback: Mensagens de confirmação (Toast/Dialog) para ações de salvar e excluir.

🛠️ Tecnologias e Arquitetura
O projeto foi construído seguindo rigorosamente a arquitetura recomendada, com separação clara de responsabilidades:
Arquitetura: MVVM (Model - View - ViewModel)
O fluxo de dados segue o padrão:
Activity/Fragment <-> ViewModel <-> Repository <-> Room Database

Principais Bibliotecas (Jetpack):
Kotlin: Linguagem principal.
Room Database: Para persistência de dados local (SQLite).
Navigation Component: Para gerenciamento de fluxo entre telas (Single Activity Architecture).
DataBinding: Para vínculo declarativo entre layouts XML e classes de dados.
LiveData & ViewModel: Para gerenciamento de estado e ciclo de vida da UI.
Coroutines: Para operações assíncronas de banco de dados.

🚀 Como Executar
Pré-requisitos:
Android Studio Iguana ou superior.
JDK 17 ou superior configurado no Gradle.
Passos
Clone este repositório.
Abra o projeto no Android Studio.
Aguarde o sincronismo do Gradle (Sync).
Execute o aplicativo em um emulador ou dispositivo físico (API 24+).

🧪 Dados para Teste (Mock Data)

Para facilitar os testes das funcionalidades de Cadastro (Create) e Edição (Update), utilize os
dados fictícios abaixo:

Kanto
Ash Ketchum
Tipo: Treinador
Região: Kanto
Idade: 10
Pokémon Principal: Pikachu
Descrição: Protagonista da série. Sonha se tornar um Mestre Pokémon e viaja por várias regiões
capturando Pokémon.

Misty
Tipo: Líder de Ginásio
Região: Kanto
Idade: 12
Pokémon Principal: Starmie
Descrição: Líder do Ginásio de Cerulean e especialista em Pokémon do tipo Água. Amiga e companheira
de Ash.

Brock
Tipo: Líder de Ginásio
Região: Kanto
Idade: 15
Pokémon Principal: Onix
Descrição: Líder do Ginásio de Pewter, especialista em Pokémon do tipo Pedra. Apaixonado por
culinária e cuidados com Pokémon.

Professor Oak
Tipo: Professor
Região: Kanto
Idade: 60
Pokémon Principal: Bulbasaur
Descrição: Cientista renomado que pesquisa Pokémon. Dá o primeiro Pokémon aos treinadores
iniciantes.

Gary Oak
Tipo: Treinador
Região: Kanto
Idade: 10
Pokémon Principal: Blastoise
Descrição: Rival de Ash e neto do Professor Oak. Confiante e competitivo.

Red
Tipo: Treinador
Região: Kanto
Idade: 11
Pokémon Principal: Charizard
Descrição: Treinador lendário que venceu a Liga Pokémon. Inspirou muitos treinadores.

Blue
Tipo: Treinador
Região: Kanto
Idade: 11
Pokémon Principal: Arcanine
Descrição: Rival de Red e neto do Professor Oak. Muito habilidoso e competitivo.

Tracey Sketchit
Tipo: Assistente de Ash
Região: Kanto
Idade: 14
Pokémon Principal: Scyther
Descrição: Artista e observador de Pokémon, viajou com Ash e Misty.

Sinnoh
Dawn
Tipo: Treinadora
Região: Sinnoh
Idade: 10
Pokémon Principal: Piplup
Descrição: Treinadora iniciante de Sinnoh que participa de concursos Pokémon e viaja com Ash.

Cynthia
Tipo: Campeã da Liga
Região: Sinnoh
Idade: 30
Pokémon Principal: Garchomp
Descrição: Campeã da Liga de Sinnoh, especialista em Pokémon poderosos. Conhecida por sua força e
inteligência.

Paul
Tipo: Treinador
Região: Sinnoh
Idade: 10
Pokémon Principal: Pikachu
Descrição: Rival de Ash em Sinnoh, sério e estratégico.

Zoey
Tipo: Treinadora
Região: Sinnoh
Idade: 12
Pokémon Principal: Roselia
Descrição: Treinadora de concursos Pokémon, rival amigável de Dawn.

Johto

Professor Elm
Tipo: Professor
Região: Johto
Idade: 50
Pokémon Principal: Chikorita
Descrição: Professor que pesquisa evolução de Pokémon e dá o primeiro Pokémon aos treinadores de
Johto.

Hoenn

May
Tipo: Treinadora
Região: Hoenn
Idade: 10
Pokémon Principal: Torchic
Descrição: Treinadora iniciante em Hoenn, participa de concursos Pokémon.

Max
Tipo: Treinador
Região: Hoenn
Idade: 8
Pokémon Principal: Azurill
Descrição: Irmão mais novo de May, viaja acompanhando a irmã e aprendendo sobre Pokémon.

Professor Birch
Tipo: Professor
Região: Hoenn
Idade: 52
Pokémon Principal: Treecko
Descrição: Professor de Hoenn, dá o primeiro Pokémon aos novos treinadores.

Brawly
Tipo: Líder de Ginásio
Região: Hoenn
Idade: 16
Pokémon Principal: Makuhita
Descrição: Líder de Ginásio de Hoenn, especialista em Pokémon de luta.

Wattson
Tipo: Líder de Ginásio
Região: Hoenn
Idade: 30
Pokémon Principal: Magnemite
Descrição: Líder de Ginásio especializado em Pokémon elétricos.

Flannery
Tipo: Líder de Ginásio
Região: Hoenn
Idade: 16
Pokémon Principal: Torkoal
Descrição: Líder de Ginásio especializada em Pokémon de fogo.

Roxanne
Tipo: Líder de Ginásio
Região: Hoenn
Idade: 15
Pokémon Principal: Geodude
Descrição: Primeira líder de Ginásio de Hoenn, especialista em Pokémon de pedra.

Kalos

Professor Sycamore
Tipo: Professor
Região: Kalos
Idade: 45
Pokémon Principal: Froakie
Descrição: Professor renomado de Kalos, fornece o primeiro Pokémon aos iniciantes.

Serena
Tipo: Treinadora
Região: Kalos
Idade: 12
Pokémon Principal: Fennekin
Descrição: Treinadora iniciante que viaja com Ash em Kalos e participa de concursos.

Clemont
Tipo: Líder de Ginásio
Região: Kalos
Idade: 15
Pokémon Principal: Luxray
Descrição: Líder de Ginásio especialista em Pokémon elétricos.

Bonnie
Tipo: Treinadora
Região: Kalos
Idade: 8
Pokémon Principal: Dedenne
Descrição: Irmã mais nova de Clemont, viaja junto com Ash e Serena.

Alola

Professor Kukui
Tipo: Professor
Região: Alola
Idade: 40
Pokémon Principal: Incineroar
Descrição: Professor e mentor dos treinadores em Alola.

Lillie
Tipo: Treinadora
Região: Alola
Idade: 11
Pokémon Principal: Alolan Vulpix
Descrição: Treinadora tímida que cresce em confiança durante sua jornada em Alola.

Kiawe
Tipo: Treinador
Região: Alola
Idade: 13
Pokémon Principal: Turtonator
Descrição: Treinador de Alola especialista em Pokémon de fogo.

Sophocles
Tipo: Treinador
Região: Alola
Idade: 12
Pokémon Principal: Charjabug
Descrição: Treinador estudioso e técnico, amigo de Ash.

Gladion
Tipo: Treinador
Região: Alola
Idade: 14
Pokémon Principal: Silvally
Descrição: Treinador sério e habilidoso, irmão de Lillie e rival de Ash em Alola.