@feature_product_detail_page
  Feature: Product Detail Page Feature

    Background:
      Given click accept cookie button on homepage

    Scenario: Verify review useful feedback successful message
      When search with "iphone" keyword on on homepage
      Then verify "iphone" search results on category page
      When click random product and go product detail on category page
      And click review tab on product detail page
      And click thumbs up button of first review on product detail page
      Then verify review feedback successful message on product detail page