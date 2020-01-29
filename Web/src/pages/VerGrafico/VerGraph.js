import React ,{Component} from 'react';
import {BarChart} from 'react-easy-chart';
import {Legend} from 'react-easy-chart';
import api from "../../services/api"

import "../../styles.css"


// A funcao verGraph mostra o grafico de Arquivo recepcionados e nao recepcionados 
export default class VerGraph extends Component{
    state = {
        Graph: []       
    }
    componentDidMount(){
        this.loadCards();
    }
    
    loadCards = async () => {
        const response = await api.get('/graficoRecepcionados')
        console.log(response.data)
        this.setState({Graph : response.data});}

    render(){
        return (//TAG BARCHAR cria o grafico
        <div>
            <BarChart className= "teste"
            colorBars
            axes
            
            axisLabels={{x: 'Numero', y: 'Quantidade de arquivos'}}
            height={530}
            width={750}
            data={[
            {x: 'Recepcionados Ufla', y: Number(this.state.Graph[0]), color: '#6EFFC5'},
            {x: 'Recepcionados Fagammon', y: Number(this.state.Graph[1]), color: '#0087FE'},
            {x: 'Nao Recepcionados Ufla', y: Number(this.state.Graph[2]), color: '#6EFFC5'},
            {x: 'Nao Recepcionados Fagammon', y: Number(this.state.Graph[3]), color: '#0087FE'},
            ]}
            />
        </div>
            
        )
    }
}
