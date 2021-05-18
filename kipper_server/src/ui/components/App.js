import React from 'react'

const Header = (props) => (
    <h1>{props.title}</h1>
);

export default class App extends React.Component {

    constructor() {
        super();
        this.state = {harbours: []};
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        fetch('/api/harbours')
            .then(response => response.json())
            .then(harbours => this.setState({harbours}));
    }

    handleChange(event){
        const textInput = event.target.value;
        this.setState({title:textInput});
    }

    render() {
        return (
            <React.Fragment>
                <Header title={'Harbours'}/>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.harbours.map((harbour, i) => (
                            <tr key={i}>
                                <td>{harbour.id}</td>
                                <td>{harbour.name}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </React.Fragment>
        )
    }
};
