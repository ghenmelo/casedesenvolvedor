import React ,{Component} from 'react';
import api from "../../services/api"

import "../../styles.css"


//Funcao que recebe os dados de todos os cards ja salvos no banco de dados
export default class VerCards extends Component{
    state = {
        Cards: []       
    }
    componentDidMount(){
        this.loadCards();
    }
    
    loadCards = async () => {
        const response = await api.get('/viewCards')
        console.log(response.data)
        this.setState({Cards : response.data});}
    
    render(){
    return (
        <div className="scroll">
        {this.state.Cards.map(cards =>(
            <article  key={cards.codigo}>
            <div className = "CardsList">
                <h5>Codigo : {cards.codigo}</h5>
                <h5>Card Primitivo :{cards.cardPrimitivo}</h5>
                <h5>Constante Instituicao :{cards.constanteInstituicao}</h5>
                <h5>Recepcionado :{cards.data}</h5>
                <h5>Numero Estabelecimento :{cards.constanteInstituicao}</h5>
                <h5>Data Criacao :{cards.data}</h5>
                <h5>Periodo Inicial :{cards.periodoInicial}</h5>
                <h5>Periodo Final :{cards.periodoFinal}</h5>
            </div>
            </article>
            
        ))}
        </div> 
    );
    }
}