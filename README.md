# 🧮 Calculadoras Científicas

> Meu primeiro aplicativo Android: um conjunto de calculadoras de física, química e conversão de unidades, construído do zero com Kotlin e Views XML.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

---

## 📋 Índice

- [Sobre o projeto](#-sobre-o-projeto)
- [Capturas de tela](#-capturas-de-tela)
- [Funcionalidades](#-funcionalidades)
- [Fórmulas utilizadas](#-fórmulas-utilizadas)
- [Design e experiência do usuário](#-design-e-experiência-do-usuário)
- [Tecnologias](#-tecnologias)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como executar](#-como-executar)
- [Pontos de atenção e próximos passos](#-pontos-de-atenção-e-próximos-passos)
- [O que aprendi construindo este app](#-o-que-aprendi-construindo-este-app)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 📱 Sobre o projeto

**Calculadoras Científicas** *(nome de trabalho, sinta-se à vontade para alterar)* é um aplicativo Android nativo que reúne, em um único menu, oito calculadoras voltadas para física, química, matemática e conversão de unidades. A ideia surgiu como projeto de estudo para aprender desenvolvimento Android do zero — desde a criação de layouts responsivos até animações customizadas, boas práticas de UX/UI e princípios de usabilidade.

Este é o meu **primeiro aplicativo Android**, construído com Kotlin e Views XML tradicionais (`ConstraintLayout`), sem frameworks externos além dos componentes oficiais do Material Design.

---

## 📸 Capturas de tela

> 🚧 *Screenshots ainda não adicionadas. Recomendo tirar prints de cada tela (Splash, Menu e as 8 calculadoras) e colar aqui antes de publicar o repositório — isso aumenta muito o impacto do README para quem visitar o projeto.*

```markdown
<p align="center">
  <img src="screenshots/splash.png" width="200" />
  <img src="screenshots/menu.png" width="200" />
  <img src="screenshots/velocidade.png" width="200" />
</p>
```

---

## ✨ Funcionalidades

### 🎬 Tela de Splash
Tela de abertura com animação de revelação: o texto "DE" aparece com fade, seguido da assinatura ("Rodrigo Mazzucco") em fonte cursiva sendo revelada progressivamente da esquerda para a direita (efeito "cortina"), e um subtítulo com fade-in. Após a sequência, o app navega automaticamente para o menu principal.

### 🏠 Menu Principal
Grade de 2 colunas × 4 linhas com botões coloridos (paleta inspirada nas sete cores do arco-íris + uma cor complementar), dentro de uma `ScrollView` para garantir que o conteúdo nunca seja cortado em telas pequenas. Cada botão navega para uma calculadora diferente via `Intent`.

### 🏎️ Velocidade Média
Calcula a velocidade média a partir da distância percorrida e do tempo gasto. O resultado só aparece depois de uma animação de um carrinho (Ferrari) atravessando a tela da direita para a esquerda, com um efeito de fumaça (rastro) atrás dele.

### 💪 Força *(Segunda Lei de Newton)*
Calculadora de força a partir de massa e aceleração. *(Tela referenciada no menu de navegação — ajuste esta descrição conforme a implementação final da sua tela `AppForca`.)*

### 🏃 Energia Cinética
Calcula a energia cinética de um objeto a partir de sua massa e velocidade. O resultado aparece após uma pequena animação de um emoji de corredor atravessando a tela, com efeito de "passada" (quique vertical).

### 🌡️ Fahrenheit → Celsius
Converte temperaturas de Fahrenheit para Celsius, sobre um fundo temático de deserto em pixel art. O resultado é revelado após uma animação de dois cavaleiros (temática western) galopando pela tela.

### 🌡️ Celsius → Fahrenheit
Mesma lógica da conversão anterior, no sentido inverso, com a mesma identidade visual e animação dos cavaleiros.

### 📦 Volume do Paralelepípedo
Calcula o volume a partir do comprimento, largura e altura da base. Tela desenhada com foco especial em usabilidade: instruções visíveis antes dos campos, teclado numérico automático e navegação por "Próximo"/"Concluído" entre os campos.

### 🧪 Equação de Torricelli
Calculadora de cinemática que resolve a velocidade final a partir da velocidade inicial, aceleração e deslocamento — incluindo o cálculo de raiz quadrada da fórmula original.

### ⚗️ Fórmula da Diluição
A calculadora mais flexível do app: a partir da fórmula C₁V₁ = C₂V₂, o usuário preenche **3 dos 4 campos** e deixa em branco exatamente aquele que deseja descobrir. O app identifica automaticamente qual variável falta e a isola na fórmula.

---

## 🧮 Fórmulas utilizadas

| Calculadora | Fórmula | Variáveis |
|---|---|---|
| Velocidade Média | `v = d / t` | d = distância, t = tempo |
| Força (2ª Lei de Newton) | `F = m × a` | m = massa (kg), a = aceleração (m/s²) |
| Energia Cinética | `E = (m × v²) / 2` | m = massa (kg), v = velocidade (m/s) |
| Fahrenheit → Celsius | `C = (F − 32) × 5/9` | F = temperatura em °F |
| Celsius → Fahrenheit | `F = C × 9/5 + 32` | C = temperatura em °C |
| Volume do Paralelepípedo | `V = c × l × a` | c = comprimento, l = largura, a = altura |
| Equação de Torricelli | `v = √(v₀² + 2 × a × Δs)` | v₀ = velocidade inicial (m/s), a = aceleração (m/s²), Δs = deslocamento (m) |
| Fórmula da Diluição | `C₁ × V₁ = C₂ × V₂` | C = concentração (%), V = volume (mL) — resolve para a variável em branco |

---

## 🎨 Design e experiência do usuário

Este projeto não foi pensado só em termos de "funcionar" — várias decisões de interface foram guiadas propositalmente por heurísticas de usabilidade (Nielsen) e boas práticas de UX/UI:

- **Responsividade real**: todos os layouts usam `ConstraintLayout` com largura `0dp` ("match constraint") ancorada em constraints de início/fim, em vez de larguras fixas em `dp` ou posicionamento absoluto — o app se adapta a qualquer tamanho e orientação de tela.
- **Visibilidade do status do sistema**: textos de instrução antes dos formulários, indicando claramente o que é esperado do usuário antes de qualquer erro acontecer.
- **Prevenção de erros**: campos numéricos usam `inputType="numberDecimal"`, abrindo o teclado correto automaticamente e reduzindo a chance de entrada inválida.
- **Eficiência de uso**: `imeOptions="actionNext"` / `"actionDone"` permite navegar entre campos pelo próprio teclado, sem precisar tocar em cada campo manualmente.
- **Consistência**: mesma tipografia (JetBrains Mono para títulos e resultados), mesmo padrão de botão "voltar", mesma estrutura de tela em cascata em todas as calculadoras.
- **Reconhecimento em vez de memorização**: nomes de botão sem ambiguidade (ex: "Fahrenheit → Celsius" em vez de "converter Fahrenheit", deixando a direção da conversão explícita).
- **Feedback e tratamento de erro**: todas as calculadoras tratam entradas inválidas com `Toast`, sem travar ou quebrar o app.
- **Estética minimalista**: a paleta de cores do menu segue a sequência das sete cores do arco-íris (mais uma cor complementar), criando uma identidade visual coesa sem exagero decorativo.

---

## 🛠️ Tecnologias

- **Kotlin** — linguagem principal
- **Android SDK** (`AppCompatActivity`, Views tradicionais em XML)
- **ConstraintLayout** — para todos os layouts responsivos
- **Material Components** — `TextInputLayout` / `TextInputEditText` com floating labels
- **Android Animation API** — `ObjectAnimator`, `AnimatorSet`, `AnimatorListenerAdapter` para as animações de transição e revelação
- **Google Fonts** — JetBrains Mono (títulos/resultados) e Carattere (assinatura cursiva na splash)
- **Edge-to-edge display** — `enableEdgeToEdge()` + `WindowInsetsCompat`

---

## 📂 Estrutura do projeto

```
app/src/main/
├── java/br/com/listamarinho1/
│   ├── TelaMenu.kt
│   ├── AppVelocidade.kt
│   ├── AppForca.kt
│   ├── AppEnergiaCinetica.kt
│   ├── AppFahrenheitCelsius.kt
│   ├── AppCelsiusFahrenheit.kt
│   ├── AppVolumeParalelepipedo.kt
│   ├── AppEquacaoTorricelli.kt
│   └── AppFormulaDiluicao.kt
├── java/br/com/calculadoras/
│   └── TelaSplash.kt          ⚠️ ver nota de pacote na seção abaixo
├── res/
│   ├── layout/
│   │   ├── telamenu.xml
│   │   ├── activity_tela_splash.xml
│   │   ├── appvelocidade.xml
│   │   ├── activity_app_energia_cinetica.xml
│   │   ├── activity_app_fahrenheit_celsius.xml
│   │   ├── activity_app_celsius_fahrenheit.xml
│   │   ├── activity_app_volume_paralelepipedo.xml
│   │   ├── activity_app_equacao_torricelli.xml
│   │   └── activity_app_formula_diluicao.xml
│   ├── drawable/
│   │   ├── ferrari.png
│   │   ├── cavaleiros.png
│   │   ├── fundo_deserto2d.png
│   │   └── arrow_back.xml
│   └── font/
│       ├── jetbrains_mono.ttf
│       ├── mclaren.ttf
│       └── carattere.ttf
└── AndroidManifest.xml
```

---

## ▶️ Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Abra o projeto no **Android Studio** (versão recente recomendada).
3. Aguarde o Gradle sincronizar as dependências.
4. Conecte um dispositivo físico ou inicie um emulador.
5. Rode o app clicando em **Run ▶** ou `Shift + F10`.

> ⚠️ A fonte "Carattere", usada na assinatura da tela de splash, precisa estar configurada como **"Add font to project"** (e não "Create downloadable font"), caso contrário ela depende de conexão com a internet e do Google Play Services para carregar — e pode não aparecer em alguns dispositivos/emuladores.

---

## ⚠️ Pontos de atenção e próximos passos

Lista honesta de itens que ainda merecem atenção antes ou depois da publicação:

- [ ] **Pacote inconsistente**: `TelaSplash` está no pacote `br.com.calculadoras`, enquanto todas as outras Activities estão em `br.com.listamarinho1`. Vale unificar tudo em um único pacote antes de publicar.
- [ ] **Acessibilidade**: as imagens puramente decorativas (carrinho, cavaleiros) ainda não têm `android:contentDescription="@null"` explícito para leitores de tela.
- [ ] **Strings hardcoded**: vários textos estão escritos direto no XML (`android:text="..."`) em vez de referenciar `res/values/strings.xml` — importante caso o app venha a ser traduzido no futuro.
- [ ] **Tela "Força"**: revisar se a implementação final bate com a fórmula documentada aqui (F = m × a).
- [ ] **Testes automatizados**: nenhuma das fórmulas possui testes unitários ainda — seria um ótimo próximo passo para reforçar o portfólio.
- [ ] **Screenshots**: adicionar capturas de tela reais ao README antes de divulgar o repositório.

---

## 🎓 O que aprendi construindo este app

Como este foi meu primeiro app Android, alguns aprendizados que valem registrar:

- A diferença entre posicionamento **absoluto** (`tools:layout_editor_absoluteX/Y`, que só existe no preview do editor) e **constraints reais** (`app:layout_constraint...`, que funcionam de fato em runtime).
- Como `layout_width="0dp"` combinado com constraints de início/fim cria layouts que se esticam de verdade — a base de qualquer layout responsivo em `ConstraintLayout`.
- Que constraints só podem referenciar **elementos irmãos diretos** dentro do mesmo `ConstraintLayout` (não filhos de outros containers, como um `FrameLayout` aninhado).
- Como animar views com `ObjectAnimator` (translação, escala, transparência) e encadear animações com `AnimatorListenerAdapter`.
- A diferença entre `TextInputLayout` (o "invólucro" visual) e `TextInputEditText` (onde o texto de fato mora).
- Por que `val` deve ser preferido a `var` em Kotlin sempre que a variável não precisa ser reatribuída.
- Como extrair funções para evitar repetição de código (princípio DRY), especialmente ao lidar com múltiplos resultados possíveis, como na calculadora de diluição.
- Aplicação prática de heurísticas de usabilidade de Nielsen em decisões reais de interface, não apenas em teoria.

---

## 👤 Autor

**Rodrigo Mazzucco**

Este é o meu primeiro projeto Android completo — feito com bastante pesquisa, tentativa e erro, e vontade de aprender. Feedbacks são muito bem-vindos!

---

## 📄 Licença

Este projeto ainda não possui uma licença definida. Para projetos de estudo e portfólio, a [MIT License](https://choosealicense.com/licenses/mit/) costuma ser uma boa escolha — permite uso livre do código mantendo os créditos ao autor original.

---

<p align="center">Feito com 💻 e bastante café por Rodrigo Mazzucco</p>
