import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import ListQuizes from './components/ListQuizes'
import ViewQuestions from './components/ViewQuestions'
import './App.css'

function App() {
  

  return (
    <>
    
    <div>
    <Router>
    <Routes>
  
          <Route path = "/" element = {<ListQuizes/>}/>
          <Route path = "/view-questions/:quizId" element = {<ViewQuestions/>}/>
      
      </Routes>
      </Router>
      </div>
    </>
  )
}

export default App
