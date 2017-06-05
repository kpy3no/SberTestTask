import React from "react";
import ReactDom from "react-dom";

import {Logger, ConsoleLogger} from 'react-console-logger';
const myLogger = new Logger();

class Drawer extends React.Component{

}

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {name: null};
    }

    componentDidMount() {
        console.log('In componentDidMount');
        client({method: 'GET', path: '/api'}).done(response => {
            this.setState({name: response.entity._embedded.name});
        });
    }


    render() {
        return (<p>Hello world {this.state.name}</p>);
    }
}


ReactDom.render(<App/>, document.getElementById('root'));
