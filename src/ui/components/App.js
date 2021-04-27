import React from 'react'

const Header = (props) => (
    <h1>{props.title}</h1>
);

export default class App extends React.Component {

    constructor() {
        super();
        this.state = {persons: []};
    }

    componentDidMount() {
        fetch('/api/persons')
            .then(response => response.json())
            .then(persons => this.setState({persons}));
    }

    render() {
        return (
            <React.Fragment>
                <Header title={'Persons'}/>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.persons.map((harbour, i) => (
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
