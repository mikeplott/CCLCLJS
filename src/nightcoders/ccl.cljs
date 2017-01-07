(ns nightcoders.ccl
  (:require [reagent.core :as r]))

(def show-form? (r/atom true))

(defn login []
  [:div
   [:div {:class "col-md-12" :id "zeNav"}
    [:h1 {:id "myHeader"} "Welcome!"]]
   [:div {:class "col-md-12" :id "formDiv"}
    [:form {:id "login" :class "form-inline"}
     [:div {:class "form-group" :id "logDiv"}
      [:label {:id "username"} "Username"]
      [:input {:type "text" :class "form-control" :id "uName"}]]
     [:div {:class "form-group" :id "logDiv"}
      [:label {:id "password"} "Password"]
      [:input {:type "password" :class "form-control" :id "pWord"}]]
     [:div {:class "form-group" :id "logDiv"}
      [:button {:id "logBtn"   :on-click (fn [event]
                                           (.preventDefault event)
                                           (swap! show-form? not))
                :class "btn btn-primary"} 
       "Submit"]]]]])

  

(defn dashboard []
  [:div
   [:br]
   [:div {:class "col-md-12" :id "zeNav"}
    [:h1 {:id "myHeader"} "Dashboard"]]
   [:div {:class "col-md-12" :id "myContainer"}
    [:div {:class "col-md-3" :id "box"}
     [:img {:src "order-entry.png" :width "250px" :height "200px"}]]
    [:div {:class "col-md-3" :id "box"}
     [:img {:src "map.jpg" :width "250px" :height "200px"}]]
    [:div {:class "col-md-3" :id "box"}
     [:img {:src "sales-report.jpg" :width "250px" :height "200px"}]]
    [:div {:class "col-md-3" :id "box"}
     [:img {:src "beer-delivery.jpg" :width "250px" :height "200px"}]]]])



(defn content []
  (if @show-form?
    [login]
    [dashboard]))
  
(r/render-component [content] (.querySelector js/document "#content"))

