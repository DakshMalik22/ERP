/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**"],
  darkMode:"class",
  theme: {
    boxShadow: {
    'custom': 'rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px',
    },
    backgroundImage: {
      'custom-gradient': 'linear-gradient(180deg, #2A2B31 0%, #2A2B3100 100%)'
    },
    screens: {
      'sm': '640px',
      // => @media (min-width: 640px) { ... }
      
      'md': '768px',
      // => @media (min-width: 768px) { ... }

      'lg': '1024px',
      // => @media (min-width: 1024px) { ... }

      'xl': '1280px',
      // => @media (min-width: 1280px) { ... }

      '2xl': '1536px',
      // => @media (min-width: 1536px) { ... }
    }
  },
  plugins: [],
}
