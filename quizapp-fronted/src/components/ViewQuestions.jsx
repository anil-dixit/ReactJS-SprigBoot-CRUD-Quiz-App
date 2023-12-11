import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getQuestionsById } from "../services/QuizService";
import { getQuizTitleById } from "../services/QuizService";
import { submitAnswers } from "../services/QuizService";
const ViewQuestions = () => {
  const { quizId } = useParams();
  const [questions, setQuestions] = useState([]);
  const [quizTitle, setQuizTitle] = useState([]);
  const [responses, setResponses] = useState({});
  const [loading, setLoading] = useState(false);
  const [results, setResults] = useState(null); // New state to store results


  useEffect(() => {
    const fetchQuestions = async () => {
      try {
        const data = await getQuestionsById(quizId);
        setQuestions(data);
      } catch (error) {
        console.error(`Error fetching questions for quiz ${quizId}:`, error);
      }
    };
    const fetchQuizTitleById = async () => {
        try {
          const data = await getQuizTitleById(quizId);
          setQuizTitle(data.category);
        } catch (error) {
          // Handle error, e.g., show an error message to the user
          console.error('Error fetching quizzes:', error);
        }
      };
  
      fetchQuizTitleById();

    fetchQuestions();
  }, [quizId,quizTitle]);
  
  const handleCheckboxChange = (questionId, selectedOption) => {
    setResponses((prevResponses) => ({
      ...prevResponses,
      [questionId]: selectedOption,
    }));
  };
  const handleSubmit = async () => {
    try {
      setLoading(true);

      const result = await submitAnswers(quizId, responses);

      console.log("Answers submitted successfully:", result);

      // Store the results in state
      setResults(result);
    } catch (error) {
      console.error("Error submitting answers:", error.message);
      // Handle error, e.g., show an error message to the user
    } finally {
      setLoading(false);
    }
  };
  return (
    <div className="py-2 px-4">
      <h1 className="mb-4 font-bold text-xl">Questions for {quizTitle} Quiz </h1>
      <ul>
        {questions.map((question,index) => (
          <li key={question.id} className="py-2 px-4">
            <strong>Question {index + 1}:</strong> {question.questionTitle} <br />
             
            <form>
              {[question.option1, question.option2, question.option3, question.option4].map((option, optionIndex) => (
                <div key={optionIndex}>
                  <input
                    type="checkbox"
                    checked={responses[question.id]==option}
                    onChange={(e) =>
                      handleCheckboxChange(question.id, option)
                    }
                  />
                  <label>{option}</label>
                </div>
              ))}
            </form>
          </li>
        ))}
      </ul>
      <button className="bg-blue-500 text-white rounded-lg py-2 px-4" onClick={handleSubmit} disabled={loading}>
        {loading ? "Submitting..." : "Submit"}
      </button>
         {/* Display results if available */}
          {results && (
        <div>
          <h2>Results</h2>
          {/* Display result information here */}
          {/* You can format and structure the result data according to your backend response */}
          <pre>{JSON.stringify(results, null, 2)}</pre>
        </div>
      )}
    </div>
  );
};

export default ViewQuestions;