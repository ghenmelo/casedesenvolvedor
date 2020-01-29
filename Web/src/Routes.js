import React  from 'react';
import {BrowserRouter,Switch ,Route} from "react-router-dom";

import Main from "./pages/arquivosRecepcionado/index"
import VerCards from "./pages/VerCards"
import NotFound from './notFound';
import VerGraph from './pages/VerGrafico';

// Possiveis rotas traçadas no programa
const Routes = () =>(
    <BrowserRouter >    
        <Switch>
            
            <Route exact path= "/arquivoRecepcionados" component={Main}></Route>
            <Route exact path= "/viewCards" component={VerCards}></Route>
            <Route exact path= "/verGraph" component={VerGraph}></Route>
            <Route path= "/" component={NotFound}></Route>
        </Switch>   
    </BrowserRouter>
)

export default Routes;