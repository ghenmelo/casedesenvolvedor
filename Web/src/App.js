import React from 'react';
import Routes from "./Routes"

import "./styles.css";

const App = () => (
    <main>
      <div className= "retangle">
          <h1 className="Titulo">Case Desenvolvedor</h1>
          <a className = "ArquivoRecepcionados" type="button" href="/arquivoRecepcionados">Arrquivo Recepcionados</a>
          <a className = "VerCards" type="button" href="/viewCards">Ver Cards</a>
          <a className = "VerGrafico" type="button" href="/verGraph">Ver Grafico</a>
          <div className = "app">
          <Routes/>
          </div>
      </div>
    </main>
);

export default App;
