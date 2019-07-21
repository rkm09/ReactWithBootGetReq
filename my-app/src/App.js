import * as React from 'react';
import './App.css';


class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      juices: [],
      isLoading: false
    };
  }
  componentDidMount() {

  this.setState({isLoading: true});

  fetch('http://localhost:8080/good-juices')

    .then(response => response.json())

    .then(data => this.setState({juices: data, isLoading: false}));

}

  render() {
    const {juices, isLoading} = this.state;


    if(isLoading) {
      return <p> Loading..</p>;
    }
    return (
      <div>
        <h2>Juice List</h2>
        {juices.map((juice) =>

  <div key={juice.id}>

    {juice.name}

  </div>

)}

      </div>
    );
  }
}

export default App;
