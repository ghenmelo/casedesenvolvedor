import React ,{Component} from 'react';
import api from "../../services/api"
 

import "./index.css";

//Funcao que mostrar os Arquivos ja recepcionados e da a opcao de recpcionalos
export default class ArquivoRecepcionados extends Component{
    state = {
        Arquivos: []       
    }
    componentDidMount(){
        this.loadArquivo();
    }
    sendArquivo = async (card,recepcionado) =>{
        if (recepcionado == "nao"){
            api.post(`/cardsRecepcionados?card=${card}`);
            window.alert("Arquivo foi recepcionado com sucesso !!!")
            window.location.href = '/arquivoRecepcionados';
        }else{
            window.alert("O arquivo nao pode ser recepcionado");
        }
    }
    
    loadArquivo = async () => {
        const response = await api.get('/cardsRecepcionados')
        this.setState({Arquivos : response.data});}
    
    render(){
    return (
        <div className="scroll">
        {this.state.Arquivos.map(arquivo =>(
            <article  key={arquivo.caminho}>
            <div className = "CardsList">
            <h5>Caminho : {arquivo.caminho}</h5>
            <h5>Card :{arquivo.card}</h5>
            <h5>Recepcionado :{arquivo.recepcionado}</h5>
            <button onClick={evento=>this.sendArquivo(arquivo.card,arquivo.recepcionado)}>Recepcionar</button>
            </div>
            </article>
            
        ))}
        </div> 
    );
    }
}