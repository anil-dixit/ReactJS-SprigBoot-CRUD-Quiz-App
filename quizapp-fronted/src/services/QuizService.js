import axios from "axios";
const QUIZ_BASE_URL="http://localhost:8080/quiz";


    export const getQuizzes = async () => {
        try {
          const response = await axios.get(`${QUIZ_BASE_URL}/get`);
          return response.data;
        } catch (error) {
          console.error('Error fetching quizzes:', error);
          throw error;
        }
      };
    export const getQuestionsById = async (quizId) => {
        try {
          const response = await axios.get(`${QUIZ_BASE_URL}/getQuestions/${quizId}`);
          return response.data;
        } catch (error) {
          console.error(`Error fetching questions for quiz ${quizId}:`, error);
          throw error;
        }
      };
      export const getQuizTitleById = async (quizId) => {
        try {
          const response = await axios.get(`${QUIZ_BASE_URL}/get/${quizId}`);
          return response.data;
        } catch (error) {
          console.error(`Error fetching quiz with ID ${quizId}:`, error);
          throw error;
        }
      };
      export const submitAnswers = async (quizId,responses) => {
        try {
          const formattedResponses = Object.entries(responses).map(([questionId, response]) => ({
            id: parseInt(questionId),
            response,
          }));
          const response = await axios.post(`${QUIZ_BASE_URL}/submit/${quizId}`,formattedResponses);
          return response.data;
        } catch (error) {
          console.error(`Error while submitting quiz with ID ${quizId}:`, error);
          throw error;
        }
      };